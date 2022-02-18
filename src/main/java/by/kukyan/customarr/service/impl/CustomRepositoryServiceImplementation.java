package by.kukyan.customarr.service.impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.service.CustomRepositoryService;
import by.kukyan.customarr.repository.Impl.CustomArrayRepository;


import java.util.List;

public class CustomRepositoryServiceImplementation implements CustomRepositoryService {

    @Override
    public void addArrayInRepository(CustomArray array){
        CustomArrayRepository arrayRepository = CustomArrayRepository.getInstance();
        arrayRepository.addArray(array);
        CustomWarehouseServiceImplementation filler = new CustomWarehouseServiceImplementation();
        filler.putArrayInWarehouse(array);
    }

    @Override
    public void addNumbersInRepository(int... args){
        CustomArray array = new CustomArray(CustomArrayIdGenerator.getNextId(), args);
        addArrayInRepository(array);
    }

    @Override
    public void addListInRepository(List<CustomArray> customArrays){
        for (CustomArray array: customArrays) {
            addArrayInRepository(array);
        }
    }

}