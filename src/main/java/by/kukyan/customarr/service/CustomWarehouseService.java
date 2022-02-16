package by.kukyan.customarr.service;

import by.kukyan.customarr.entity.CustomArray;

import java.util.List;

public interface CustomWarehouseService {

    void putArrayInWarehouse(CustomArray array);

    void putNumbersInWarehouse(int... args);

    void putListInWarehouse(List<CustomArray> arrayEntities);

}
