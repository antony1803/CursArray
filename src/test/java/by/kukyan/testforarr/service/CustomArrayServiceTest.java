package by.kukyan.testforarr.service;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.entity.CustomArrayParameters;
import by.kukyan.customarr.entity.Warehouse;
import by.kukyan.customarr.exception.CustomCollectionExcepion;
import by.kukyan.customarr.observer.impl.CustomArrayObserver;
import by.kukyan.customarr.repository.Impl.CustomArrayRepository;
import by.kukyan.customarr.service.impl.CustomArrayService;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class CustomArrayServiceTest {
    private static CustomArrayService arrayService;
    private static Warehouse wh = Warehouse.getInstance();
    private static CustomArrayRepository cr = CustomArrayRepository.getInstance();
    private CustomArray array;

    @BeforeMethod
    public void setUp(){
        array = new CustomArray(100001, 12, 3, -2, 13, -45);
        arrayService = new CustomArrayService();
    }

    @Test
    public void  testFindMinElement(){
        OptionalInt expected = OptionalInt.of(-45);
        OptionalInt temp = arrayService.min(array);
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void  testFindMaxElement(){
        OptionalInt expected = OptionalInt.of(13);
        OptionalInt temp = arrayService.max(array);
        Assert.assertEquals(expected, temp);
    }
    @Test
    public void testChangeSigns() {
        CustomArray expected = new CustomArray(100001, -12, -3, 2,-13, 45);
        arrayService.changeSign(array);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void calculateAvg() {
        OptionalDouble expected = OptionalDouble.of(-3.8);
        OptionalDouble temp = arrayService.avg(array);
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void calculateSum() {
        OptionalLong expected = OptionalLong.of(-19);
        OptionalLong temp = arrayService.sum(array);
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void countPositiveNumbers() {
        int expected = 3;
        int temp = arrayService.countPositive(array);
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void countNegativeNumbers() {
        int expected = 2;
        int temp = arrayService.countNegative(array);
        Assert.assertEquals(expected, temp);
    }
    @Test
    public void testBubbleSort() {
        CustomArray expected = new CustomArray(100001,-45, -2, 3, 12, 13);
        arrayService.bubbleSort(array);
        Assert.assertEquals(expected, array);
    }
    @Test
    public void testSelectionSort() {
        CustomArray expected = new CustomArray(100001,-45, -2, 3, 12, 13);
        arrayService.selectionSort(array);
        Assert.assertEquals(expected, array);
    }
    @Test
    public void testInsertionSort() {
        CustomArray expected = new CustomArray(100001,-45, -2, 3, 12, 13);
        arrayService.insertionSort(array);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void replacementTest() throws CustomCollectionExcepion {
        wh.putById(array.getId(), new CustomArrayParameters(13, -45, -3.8, -19));
        cr.addArray(array);
        array.attach(new CustomArrayObserver());
        CustomArrayParameters expected = new CustomArrayParameters(13, -45, -1.4, -7);
        arrayService.replace(array, -2, 10);
        Assert.assertEquals(wh.getById(array.getId()), expected);
    }
}
