package by.kukyan.customarr.CustomAction.impl;

import by.kukyan.customarr.CustomAction.CustomArraySort;
import by.kukyan.customarr.entity.CustomArray;

import java.util.Random;

public class CustomArraySortImplementation implements CustomArraySort {
    @Override
    public CustomArray bubleSort(CustomArray customArray) {
        int[] array = customArray.getArray();
        boolean unsorted = true;
        bubleCykle(array);
        Random rnd = new Random();
        return new CustomArray(rnd.nextInt(100000), array);
    }

    public static void bubleCykle(int[] array) {
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
