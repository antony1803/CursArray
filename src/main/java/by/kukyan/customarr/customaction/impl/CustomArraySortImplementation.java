package by.kukyan.customarr.customaction.impl;

import by.kukyan.customarr.creator.CustomArrayCreator;
import by.kukyan.customarr.customaction.CustomArraySort;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.service.impl.CustomArrayIdGenerator;


public class CustomArraySortImplementation implements CustomArraySort {
    @Override
    public CustomArray bubbleSort(CustomArray customArray) {
        int[] array = customArray.getArray();
        bubbleCycle(array);
        return CustomArrayCreator.createArray(CustomArrayIdGenerator.getNextId(), array);
    }

    public static void bubbleCycle(int[] array) {
        boolean unsorted;
        for (int i = array.length; i > 0; i--) {
            unsorted = false;
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                   unsorted = true;
                }
            }
            if (!unsorted) {
                break;
            }
        }
    }
}
