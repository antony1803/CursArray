package by.kukyan.customarr.creator;

import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.service.impl.CustomArrayIdGenerator;

import java.util.Random;

public class CustomArrayCreator {
    private CustomArrayCreator(){}

    public static CustomArray createArray (int newId, int ... arr){
        return new CustomArray(newId, arr);
    }

    public static CustomArray createRandomArray (int lengthBoundary, int elementBoundary){
        if(lengthBoundary <= 0){
            return new CustomArray();
        }
        Random rnd = new Random();
        int length = rnd.nextInt(lengthBoundary);
        int id = CustomArrayIdGenerator.getNextId();
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = rnd.nextInt(elementBoundary);
        }
        return new CustomArray(id, arr);
    }

}
