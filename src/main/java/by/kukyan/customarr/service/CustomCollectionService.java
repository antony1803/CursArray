package by.kukyan.customarr.service;

import by.kukyan.customarr.entity.CustomCollection;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface CustomCollectionService {
    OptionalDouble avg(CustomCollection customCollection);
    void changeSign(CustomCollection customCollection);
    int countPositive(CustomCollection customCollection);
    int countNegative(CustomCollection customCollection);
    OptionalInt max(CustomCollection customCollection);
    OptionalInt min(CustomCollection customCollection);
    void bubleSort(CustomCollection customCollection);
    void insertionSort(CustomCollection customCollection);
    void selectionSort(CustomCollection customCollection);
    OptionalLong sum(CustomCollection customCollection);
}
