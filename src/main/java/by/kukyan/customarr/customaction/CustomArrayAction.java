package by.kukyan.customarr.customaction;

import by.kukyan.customarr.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface CustomArrayAction {
    OptionalInt getMin(CustomArray customArray);

    OptionalInt getMax(CustomArray customArray);

    OptionalDouble getAvg(CustomArray customArray);

    OptionalLong getSum(CustomArray customArray);

    long getNumberOfPositive(CustomArray customArray);

    long getNumberOfNegative(CustomArray customArray);

    CustomArray replaceElement(CustomArray customArray, int positionOfElementForReplacement, int newElement);
}
