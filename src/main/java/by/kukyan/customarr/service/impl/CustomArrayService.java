package by.kukyan.customarr.service.impl;

import by.kukyan.customarr.service.CustomCollectionService;
import by.kukyan.customarr.entity.CustomCollection;

import java.util.Optional;
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
        for (int i = array.length; i > 0; i--) {
            hasSwitched = false;
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    hasSwitched = true;
                }
            }
            if (!hasSwitched) {
                break;
            }
        }
        customCollection.setArray(array);
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
