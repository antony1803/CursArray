package by.kukyan.customarr.repository.Impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Specification;

public class EqualLengthSpecification implements Specification {
    private int length;

    EqualLengthSpecification(int newLength){
        length = newLength;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getArrayLength() == length;
    }
}
