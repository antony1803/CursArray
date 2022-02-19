package by.kukyan.testforarr.service;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.service.impl.CustomArrayService;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class CustomArrayServiceTest {
    CustomArrayService arrayService;

    @BeforeMethod
    public void setUp(){
        arrayService = new CustomArrayService();
    }

    @Test
    public void  testFindMinElement(){
        CustomArray array = new CustomArray(12, 3, -2,13, -45);
        OptionalInt expected = OptionalInt.of(-45);
        OptionalInt temp = arrayService.min(array);
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void  testFindMaxElement(){
        CustomArray array = new CustomArray(12, 3, -2,13, -45);
        OptionalInt expected = OptionalInt.of(13);
        OptionalInt temp = arrayService.max(array);
        Assert.assertEquals(expected, temp);
    }
    @Test
    public void testChangeSigns() {
        CustomArray array = new CustomArray(12, 3, -2,13, -45);
        CustomArray expected = new CustomArray(-12, -3, 2,-13, 45);
        arrayService.changeSign(array);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void calculateAvg() {
        CustomArray array = new CustomArray(12, 3, -2, 13, -45);
        OptionalDouble expected = OptionalDouble.of(-3.8);
        OptionalDouble temp = arrayService.avg(array);
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void calculateSum() {
        CustomArray array = new CustomArray(12, 3, -2, 13, -45);
        OptionalLong expected = OptionalLong.of(-19);
        OptionalLong temp = arrayService.sum(array);
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void countPositiveNumbers() {
        CustomArray array = new CustomArray(12, 3, -2, 13, -45);
        int expected = 3;
        int temp = arrayService.countPositive(array);
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void countNegativeNumbers() {
        CustomArray array = new CustomArray(12, 3, -2, 13, -45);
        int expected = 2;
        int temp = arrayService.countNegative(array);
        Assert.assertEquals(expected, temp);
    }
    @Test
    public void testBubbleSort() {
        CustomArray array = new CustomArray(12, 3, -2,13, -45);
        CustomArray expected = new CustomArray(-45, -2, 3,12, 13);
        arrayService.bubbleSort(array);
        Assert.assertEquals(expected, array);
    }
    @Test
    public void testSelectionSort() {
        CustomArray array = new CustomArray(12, 3, -2,13, -45);
        CustomArray expected = new CustomArray(-45, -2, 3,12, 13);
        arrayService.selectionSort(array);
        Assert.assertEquals(expected, array);
    }
    @Test
    public void testInsertionSort() {
        CustomArray array = new CustomArray(12, 3, -2,13, -45);
        CustomArray expected = new CustomArray(-45, -2, 3,12, 13);
        arrayService.insertionSort(array);
        Assert.assertEquals(expected, array);
    }

}
