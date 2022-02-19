package by.kukyan.testforarr.creator;

import by.kukyan.customarr.creator.CustomArrayCreator;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.service.impl.CustomArrayIdGenerator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CustomArrayCreatorTest {

    @Test
    public void testOfCreation(){
        int tempId = CustomArrayIdGenerator.getNextId();
        CustomArray firstArray = CustomArrayCreator.createArray(tempId, 1, 2, 3, 4, 5);
        CustomArray secondArray = new CustomArray(tempId, 1, 2, 3, 4, 5);
        Assert.assertEquals(firstArray, secondArray);
    }

    @Test
    public void testRandomCreation(){
        CustomArray array = CustomArrayCreator.createRandomArray(1000, 200);
        int[] arr = array.getArray();
        long invalidValues = array.getArrayLength() <= 1000 ? 0 : 1;
        long invalidElements = Arrays.stream(arr, 0, arr.length).filter(el -> (el > 200)).count();
        Assert.assertEquals(invalidElements + invalidValues, 0);

    }
}
