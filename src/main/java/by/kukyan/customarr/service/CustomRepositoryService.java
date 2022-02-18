package by.kukyan.customarr.service;

import by.kukyan.customarr.entity.CustomArray;

import java.util.List;

public interface CustomRepositoryService {

    void addArrayInRepository(CustomArray array);

    void addNumbersInRepository(int... args);

    void addListInRepository(List<CustomArray> arrayEntities);
}
