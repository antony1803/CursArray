package by.kukyan.testforarr.observer;

import by.kukyan.customarr.creator.CustomArrayCreator;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.entity.CustomArrayParameters;
import by.kukyan.customarr.entity.Warehouse;
import by.kukyan.customarr.exception.CustomCollectionExcepion;
import by.kukyan.customarr.observer.impl.CustomArrayEvent;
import by.kukyan.customarr.observer.impl.CustomArrayObserver;
import by.kukyan.customarr.repository.Impl.CustomArrayRepository;

import by.kukyan.customarr.service.impl.CustomWarehouseServiceImplementation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomArrayObserverTest {
    private static Warehouse wh = Warehouse.getInstance();
    private static CustomArrayRepository cr = CustomArrayRepository.getInstance();
    private static CustomWarehouseServiceImplementation service;
    private CustomArrayObserver observer;
    private CustomArray array;
    private CustomArrayEvent event;


    @BeforeMethod
    public void setUp()  {
        array = CustomArrayCreator.createArray(100001, 12, 3, -2, 13, -45);
        service = new CustomWarehouseServiceImplementation();
        observer = new CustomArrayObserver();
        event = new CustomArrayEvent(array);
        service.putArrayInWarehouse(array);
        wh.putById(array.getId(), new CustomArrayParameters(13, -45, -3.8, -19));
        cr.addArray(array);
        array.attach(observer);
    }

    @Test
    public void arrayReplacement() throws CustomCollectionExcepion {
        CustomArrayParameters expected = new CustomArrayParameters(4, 1, 2.5, 10);
        array.setArray(1, 2, 3, 4);
        array.notifyObserver();
        Assert.assertEquals(wh.getById(array.getId()), expected);
    }

    @Test
    public void elementReplacement() throws CustomCollectionExcepion {
        CustomArrayParameters expected = new CustomArrayParameters(13, -45, -6.2, -31);
        array.setElement(0, 0);
        array.notifyObserver();
        Assert.assertEquals(wh.getById(array.getId()), expected);
    }
    // Тест сервисной функции replace(СstomArray, ElementToChange, ElementForExchange,  соответствующем тестовом классе реализован с проверкой работы можели
}
