package by.kukyan.testforarr.comparator;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.creator.CustomArrayCreator;
import by.kukyan.customarr.comparator.CustomArrayComparator;
import by.kukyan.customarr.service.impl.CustomArrayIdGenerator;
import by.kukyan.customarr.comparator.CustomArrayComparatorById;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ComparatorTest {
    @Test
    public void compareEqualArraysById(){
        var comparator = new CustomArrayComparatorById();
        int id = CustomArrayIdGenerator.getNextId();
        CustomArray firstArray = new CustomArray(id, 1, 2, 3, 4, 5);
        CustomArray secondArray = new CustomArray(id, 1, 2, 3, 4, 5);
        int actual = comparator.compare(firstArray, secondArray);
        Assert.assertEquals(actual, 0);
    }

    @Test
    public void compareNonEqualArraysById(){
        var comparator = new CustomArrayComparatorById();
        int firstId = CustomArrayIdGenerator.getNextId();
        int secondId = CustomArrayIdGenerator.getNextId();
        CustomArray firstArray = new CustomArray(firstId, 1, 2, 3, 4, 5);
        CustomArray secondArray = new CustomArray(secondId, 1, 2, 3, 4, 5);
        int actual = comparator.compare(firstArray, secondArray);
        int expected = firstId - secondId;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void compareEqualCustomArrays(){
        var comparator = new CustomArrayComparator();
        int id = CustomArrayIdGenerator.getNextId();
        CustomArray firstArray = new CustomArray(id, 1, 2, 3, 4, 5);
        CustomArray secondArray = new CustomArray(id, 1, 2, 3, 4, 5);
        int actual = comparator.compare(firstArray, secondArray);
        Assert.assertEquals(actual, 0);
    }

    @Test
    public void compareCustomArraysWithEqualArraysButDifferenceInId(){
        var comparator = new CustomArrayComparator();
        int firstId = CustomArrayIdGenerator.getNextId();
        int secondId = CustomArrayIdGenerator.getNextId();
        CustomArray firstArray = new CustomArray(firstId, 1, 2, 3, 4, 5);
        CustomArray secondArray = new CustomArray(secondId, 1, 2, 3, 4, 5);
        int actual = comparator.compare(firstArray, secondArray);
        int expected = firstId - secondId;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void compareNonEqualCustomArrays(){
        var comparator = new CustomArrayComparator();
        CustomArray firstArray = CustomArrayCreator.createRandomArray(100, 200);
        CustomArray secondArray = CustomArrayCreator.createRandomArray(10, 15);
        int actual = comparator.compare(firstArray, secondArray);
        int expected = Arrays.equals(firstArray.getArray(), secondArray.getArray()) ?
                firstArray.getId() - secondArray.getId():
                Arrays.compare(firstArray.getArray(), secondArray.getArray());
        Assert.assertEquals(actual, expected);
    }

}
