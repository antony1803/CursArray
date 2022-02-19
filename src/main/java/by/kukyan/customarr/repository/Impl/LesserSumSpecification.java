package by.kukyan.customarr.repository.Impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Specification;
import by.kukyan.customarr.service.impl.CustomArrayService;

public class LesserSumSpecification implements Specification{
    private long sum;
    public LesserSumSpecification(long temp){
        sum = temp;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        var customArrayService = CustomArrayService.getInstance();
        if(!(customArrayService.sum(customArray)).isPresent()){
            return false;
        }
        return (customArrayService.sum(customArray)).getAsLong() < sum;
    }
}
