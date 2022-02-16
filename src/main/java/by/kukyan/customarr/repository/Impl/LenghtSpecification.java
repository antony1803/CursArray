package by.kukyan.customarr.repository.Impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Specification;

public class LenghtSpecification implements Specification {
    private int length;
    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getArrayLength() == length;
    }
}
