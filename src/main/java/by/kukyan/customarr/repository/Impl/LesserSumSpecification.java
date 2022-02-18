package by.kukyan.customarr.repository.Impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Specification;
import by.kukyan.customarr.customaction.impl.CustomArrayActionImplementation;

public class LesserSumSpecification implements Specification{
    private long sum;
    public LesserSumSpecification(long temp){
        sum = temp;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        var customArrayActionImplementation = new CustomArrayActionImplementation();
        if(!(customArrayActionImplementation.getSum(customArray)).isPresent()){
            return false;
        }
        return (customArrayActionImplementation.getSum(customArray)).getAsLong() < sum;
    }
}
