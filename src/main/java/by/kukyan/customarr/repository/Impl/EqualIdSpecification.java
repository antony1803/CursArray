package by.kukyan.customarr.repository.Impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Specification;

public class EqualIdSpecification implements Specification {
    private int id;

    public EqualIdSpecification(int newId){
        id = newId;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getId() == id;
    }
}
