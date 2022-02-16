package by.kukyan.customarr.customaction.impl;

import by.kukyan.customarr.customaction.CustomArrayAction;
import by.kukyan.customarr.entity.CustomArray;


import java.util.*;
import java.util.stream.IntStream;

public class CustomArrayActionImplementation implements CustomArrayAction {

    private static CustomArrayActionImplementation instance;

    public static CustomArrayActionImplementation getInstance(){
        if(instance == null){
            instance = new CustomArrayActionImplementation();
        }
        return instance;
    }


    public IntStream convertToIntStream(CustomArray customArray){
        int[] numbers = customArray.getArray();
        return Arrays.stream(numbers);
    }

    @Override
    public OptionalInt getMin(CustomArray customArray) {
        IntStream minimum = convertToIntStream(customArray);
        return minimum.min();
    }

    @Override
    public OptionalInt getMax(CustomArray customArray) {
        IntStream maximum = convertToIntStream(customArray);
        return maximum.max();
    }

    @Override
    public OptionalDouble getAvg(CustomArray customArray) {
        IntStream avg = convertToIntStream(customArray);
        return avg.average();
    }

    @Override
    public OptionalLong getSum(CustomArray customArray) {
        IntStream temp = convertToIntStream(customArray);
        return OptionalLong.of(temp.sum());
    }

    @Override
    public long getNumberOfPositive(CustomArray customArray) {
        IntStream temp = convertToIntStream(customArray);
        return temp.filter(i -> (i > 0)).count();
    }

    @Override
    public long getNumberOfNegative(CustomArray customArray) {
        IntStream temp = convertToIntStream(customArray);
        return temp.filter(i -> (i < 0)).count();
    }

    @Override
    public CustomArray replaceElement(CustomArray customArray, int elementToChange, int newElement) {
        if (customArray.getArrayLength() == 0){
            return customArray;
        }
        CustomArray newCustomArray;
        int[] numbers = customArray.getArray();
        IntStream minus = IntStream.of(numbers).map(i -> {
            if (i == elementToChange) {
                i = newElement;
            }
            return i;
        });
        Random rnd = new Random();
        newCustomArray = new CustomArray(rnd.nextInt(100000), minus.toArray());
        return newCustomArray;
    }
}
