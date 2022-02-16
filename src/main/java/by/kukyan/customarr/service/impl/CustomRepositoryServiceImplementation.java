package by.kukyan.customarr.service.impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.service.CustomRepositoryService;
import by.kukyan.customarr.repository.Impl.CustomArrayRepository;


import java.util.List;
import java.util.Random;

public class CustomRepositoryServiceImplementation implements CustomRepositoryService {

    @Override
    public void addArrayInRepo(CustomArray array){
        CustomArrayRepository arrayRepository = CustomArrayRepository.getInstance();
        arrayRepository.addArray(array);
        CustomWarehouseServiceImplementation filler = new CustomWarehouseServiceImplementation();
        filler.putArrayInWarehouse(array);
    }

    @Override
    public void addNumberInRepo(int... args){
        Random rnd = new Random();
        CustomArray array = new CustomArray(rnd.nextInt(100000), args);
        addArrayInRepo(array);
    }

    @Override
    public void addListInRepo(List<CustomArray> customArrays){
        for (CustomArray array: customArrays) {
            addArrayInRepo(array);
        }
    }

}