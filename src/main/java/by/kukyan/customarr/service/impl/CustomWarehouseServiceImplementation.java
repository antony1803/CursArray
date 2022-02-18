package by.kukyan.customarr.service.impl;

import by.kukyan.customarr.customaction.impl.CustomArrayActionImplementation;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.entity.CustomArrayStatistics;
import by.kukyan.customarr.entity.Warehouse;
import by.kukyan.customarr.service.CustomWarehouseService;


import java.util.*;

public class CustomWarehouseServiceImplementation implements CustomWarehouseService {

    @Override
    public void putArrayInWarehouse(CustomArray array){
        int id = array.getId();
        CustomArrayActionImplementation action = CustomArrayActionImplementation.getInstance();
        OptionalLong sum = action.getSum(array);
        OptionalInt min = action.getMin(array);
        OptionalInt max = action.getMax(array);
        OptionalDouble avg = action.getAvg(array);
        CustomArrayStatistics statistics = new CustomArrayStatistics();
        if(sum.isPresent()) {
            statistics.setSum(sum.getAsLong());
            statistics.setAvg(avg.getAsDouble());
            statistics.setMax(max.getAsInt());
            statistics.setMin(min.getAsInt());
            //Присутствует один параметр, присутствуют все
        }
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.putById(id, statistics);
    }

    @Override
    public void putNumbersInWarehouse(int... args){
        Random rnd = new Random();
        CustomArray array = new CustomArray(rnd.nextInt(100000), args);
        putArrayInWarehouse(array);
    }


    @Override
    public void putListInWarehouse(List<CustomArray> arrayEntities){
        for (CustomArray array: arrayEntities) {
            putArrayInWarehouse(array);
        }
    }

}
