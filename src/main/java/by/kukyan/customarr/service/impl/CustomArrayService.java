package by.kukyan.customarr.service.impl;

import by.kukyan.customarr.customaction.impl.CustomArraySortImplementation;
import by.kukyan.customarr.service.CustomCollectionService;
import by.kukyan.customarr.entity.CustomCollection;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class CustomArrayService implements CustomCollectionService {

    @Override
    public OptionalDouble avg(CustomCollection customCollection) {
        double sum = 0;
        int[] array = customCollection.getArray();
        if (array.length == 0) {
            return OptionalDouble.empty();
        }
        for (int el : array) {
            sum += el;
        }
        return OptionalDouble.of((sum / array.length));
    }

    @Override
    public void changeSign(CustomCollection customCollection) {
        int[] array = customCollection.getArray();
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
        customCollection.setArray(array);
    }

    @Override
    public int countPositive(CustomCollection customCollection) {
        int count = 0;
        int[] array = customCollection.getArray();
        for (int el : array) {
            if (el > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countNegative(CustomCollection customCollection) {
        int count = 0;
        int[] array = customCollection.getArray();
        for (int el : array) {
            if (el < 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public OptionalInt max(CustomCollection customCollection) {

        int[] array = customCollection.getArray();
        if (array.length == 0) {
            return OptionalInt.empty();
        } else {
            int max = array[0];
            for (int el : array) {
                if (el > max) {
                    max = el;
                }
            }
            return OptionalInt.of(max);
        }
    }

    @Override
    public OptionalLong sum(CustomCollection customCollection) {
        int[] array = customCollection.getArray();
        if (array.length == 0) {
            return OptionalLong.empty();
        } else {
            long sum = 0;
            for (int el : array) {
                sum += el;
            }
            return OptionalLong.of(sum);
        }
    }


    @Override
    public OptionalInt min(CustomCollection customCollection) {
        int[] array = customCollection.getArray();
        if (array.length == 0) {
            return OptionalInt.empty();
        } else {
            int max = array[0];
            for (int el : array) {
                if (el < max) {
                    max = el;
                }
            }
            return OptionalInt.of(max);
        }
    }

    @Override
    public void bubleSort(CustomCollection customCollection) {
        int[] array = customCollection.getArray();
        boolean hasSwitched;
        CustomArraySortImplementation.bubleCykle(array);
        customCollection.setArray(array);
    }

    @Override
    public void insertionSort(CustomCollection customCollection) {
        int[] array = customCollection.getArray();
        int key;
        int lastIndex;
        int firstIndex;

        for (int i = 0; i < array.length; i++) {

            key = array[i];
            lastIndex = i;
            firstIndex = 0;

            lastIndex = binarySearch(firstIndex, lastIndex, array, key);

            for (int j = i; j > lastIndex; j--) {
                array[j] = array[j - 1];
            }

            array[lastIndex] = key;
            customCollection.setArray(array);

        }
    }

    private int binarySearch(int firstIndex, int lastIndex, int[] array, int element) {
        int last;
        int first;
        int middle;

        last = lastIndex;
        first = firstIndex;

        while (first < last){

            middle = first + (last - first)/ 2;

            if (element < array[middle]){
                last = middle;
            }else{
                first = middle + 1;
            }
        }

        return first;
    }

    @Override
    public void selectionSort(CustomCollection customCollection) {
        int[] array = customCollection.getArray();

        int pos;
        int temp;

        for (int i = 0; i < array.length; i++) {

            pos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[pos]) {
                    pos = j;
                }
            }

            temp = array[pos];
            array[pos] = array[i];
            array[i] = temp;
        }

        customCollection.setArray(array);
    }


}
