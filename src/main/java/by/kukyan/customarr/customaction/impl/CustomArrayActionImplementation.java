package by.kukyan.customarr.customaction.impl;

import by.kukyan.customarr.customaction.CustomArrayAction;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.service.impl.CustomArrayIdGenerator;

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

    @Override
    public OptionalInt getMin(CustomArray customArray) {
        int [] arr = customArray.getArray();
        return Arrays.stream(arr, 0, arr.length).min();
    }

    @Override
    public OptionalInt getMax(CustomArray customArray) {
        int [] arr = customArray.getArray();
        return Arrays.stream(arr, 0, arr.length).max();
    }

    @Override
    public OptionalDouble getAvg(CustomArray customArray) {
        int [] arr = customArray.getArray();
        return Arrays.stream(arr, 0, arr.length).average();
    }

    @Override
    public OptionalLong getSum(CustomArray customArray) {
        int [] arr = customArray.getArray();
        if(arr.length == 0){
            return OptionalLong.empty();
        }
        return OptionalLong.of(Arrays.stream(arr, 0, arr.length).sum());
    }

    @Override
    public long getNumberOfPositive(CustomArray customArray) {
        int [] arr = customArray.getArray();
        return Arrays.stream(arr, 0, arr.length).filter(el -> (el > 0)).count();
    }

    @Override
    public long getNumberOfNegative(CustomArray customArray) {
        int [] arr = customArray.getArray();
        return Arrays.stream(arr, 0, arr.length).filter(el -> (el < 0)).count();
    }

    @Override
    public CustomArray replaceElement(CustomArray customArray, int elementToChange, int newElement) {
        if (customArray.getArrayLength() == 0){
            return customArray;
        }
        CustomArray newCustomArray;
        int[] array = customArray.getArray();
        IntStream replacementStream = IntStream.of(array).map(el -> {
            if (el == elementToChange) {
                el = newElement;
            }
            return el;
        });
        newCustomArray = new CustomArray(CustomArrayIdGenerator.getNextId(), replacementStream.toArray());
        return newCustomArray;
    }
}
