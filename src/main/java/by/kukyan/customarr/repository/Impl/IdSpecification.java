package by.kukyan.customarr.repository.Impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Specification;

public class IdSpecification implements Specification {
    private int id;

    public IdSpecification(int newId){
        id = newId;
    }
    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getId() == id;
    }
}
