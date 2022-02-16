package by.kukyan.customarr.repository.Impl;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Specification;
import by.kukyan.customarr.customaction.impl.CustomArrayActionImplementation;

public class SumSpecification implements Specification{
    private long sum;
    public SumSpecification(long temp){
        sum = temp;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        CustomArrayActionImplementation customArrayActionImplementation = new CustomArrayActionImplementation();
        return (customArrayActionImplementation.getSum(customArray)).getAsLong() < sum;
    }
}
