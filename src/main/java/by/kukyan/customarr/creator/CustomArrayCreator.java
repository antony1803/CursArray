package by.kukyan.customarr.creator;

import by.kukyan.customarr.entity.CustomArray;

import java.util.Random;

public class CustomArrayCreator {
    public CustomArray createArray (int newId, int ... arr){
        return new CustomArray(newId, arr);
    }

    public CustomArray createRandomArray (int lengthBoundary, int elementBoudary){
        Random rnd = new Random();
        int length = rnd.nextInt(lengthBoundary);
        int id = rnd.nextInt(100000);
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = rnd.nextInt(elementBoudary);
        }
        return new CustomArray(id, arr);
    }

}
