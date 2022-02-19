package by.kukyan.customarr.service.impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.entity.CustomArrayParameters;
import by.kukyan.customarr.entity.Warehouse;
import by.kukyan.customarr.service.CustomWarehouseService;

import java.util.*;

public class CustomWarehouseServiceImplementation implements CustomWarehouseService {

    @Override
    public void putArrayInWarehouse(CustomArray array){
        int id = array.getId();
        CustomArrayService service = CustomArrayService.getInstance();
        OptionalLong sum = service.sum(array);
        OptionalInt min = service.min(array);
        OptionalInt max = service.max(array);
        OptionalDouble avg = service.avg(array);
        CustomArrayParameters parameters = new CustomArrayParameters();
        if(sum.isPresent()) {
            parameters.setSum(sum.getAsLong());
            parameters.setAvg(avg.getAsDouble());
            parameters.setMax(max.getAsInt());
            parameters.setMin(min.getAsInt());
        }
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.putById(id, parameters);
    }

    @Override
    public void putNumbersInWarehouse(int... args){
        CustomArray array = new CustomArray(CustomArrayIdGenerator.getNextId(), args);
        putArrayInWarehouse(array);
    }


    @Override
    public void putListInWarehouse(List<CustomArray> customArrays){
        for (CustomArray array: customArrays) {
            putArrayInWarehouse(array);
        }
    }

}
