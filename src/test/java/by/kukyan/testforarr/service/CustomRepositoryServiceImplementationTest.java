package by.kukyan.testforarr.service;

import by.kukyan.customarr.creator.CustomArrayCreator;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Impl.CustomArrayRepository;
import by.kukyan.customarr.service.impl.CustomRepositoryServiceImplementation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CustomRepositoryServiceImplementationTest {
    private final CustomArray customArray = CustomArrayCreator.createArray(100001, 1, 2, 3, 4);
    private final CustomArrayRepository repository = CustomArrayRepository.getInstance();
    private final CustomRepositoryServiceImplementation service = new CustomRepositoryServiceImplementation();

    @Test
    public void addArrayInRepository(){
        service.addArrayInRepository(customArray);
        Assert.assertEquals(repository.get(0), customArray);
    }

    @Test
    public void addNumbersInRepository(){
        service.addNumbersInRepository(1, 2, 3, 4);
        Assert.assertEquals(repository.get(0), customArray);
    }

    @Test
    public void addListInRepository(){
        ArrayList<CustomArray> arrays = new ArrayList<>();
        CustomArray first = CustomArrayCreator.createRandomArray(10, 10);
        CustomArray second = CustomArrayCreator.createRandomArray(10, 10);
        CustomArray third = CustomArrayCreator.createRandomArray(10, 10);
        arrays.add(first);
        arrays.add(second);
        arrays.add(third);
        service.addListInRepository(arrays);
        Assert.assertEquals(arrays, repository.getRepository());
    }

}
