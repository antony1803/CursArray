package by.kukyan.testforarr.service;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.entity.CustomArrayParameters;
import by.kukyan.customarr.entity.Warehouse;
import by.kukyan.customarr.exception.CustomCollectionExcepion;
import by.kukyan.customarr.service.impl.CustomWarehouseServiceImplementation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomWarehouseServiceImplementationTest {
    private final Warehouse warehouse = Warehouse.getInstance();
    private final CustomArrayParameters statistics = new CustomArrayParameters(12, 0, 6, 24);
    private final CustomWarehouseServiceImplementation service = new CustomWarehouseServiceImplementation();
    private CustomArray customArray = new CustomArray(100001, 0, 4, 8, 12);

    @Test
    public void putArrayInWarehouse(){
        service.putArrayInWarehouse(new CustomArray(100001, 0, 4, 8, 12));
        try {
            Assert.assertEquals(warehouse.getById(100001), statistics);
        } catch (CustomCollectionExcepion e) {
            e.printStackTrace();
        }
    }

    @Test
    public void putNumbersInWarehouse(){
        service.putNumbersInWarehouse(0, 4, 8, 12);
        try {
            Assert.assertEquals(warehouse.getById(100001), statistics);
        } catch (CustomCollectionExcepion e) {
            e.printStackTrace();
        }
    }

}
