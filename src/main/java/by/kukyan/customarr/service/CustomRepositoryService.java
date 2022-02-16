package by.kukyan.customarr.service;

import by.kukyan.customarr.entity.CustomArray;

import java.util.List;

public interface CustomRepositoryService {

    void addArrayInRepo(CustomArray array);

    void addNumberInRepo(int... args);

    void addListInRepo(List<CustomArray> arrayEntities);
}
