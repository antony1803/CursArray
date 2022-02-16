package by.kukyan.customarr.creator;

import by.kukyan.customarr.entity.CustomArray;

import java.util.Random;

public class CustomArrayCreator {
    public CustomArray createArray (int newId, int ... arr){
        return new CustomArray(newId, arr);
    }

    public CustomArray createRandomArray (){
        Random rnd = new Random();
        int lenght = rnd.nextInt(100);
        int id = rnd.nextInt(100000);
        int[] arr = new int[lenght];
        for(int i = 0; i < lenght; i++){
            arr[i] = rnd.nextInt(50);
        }
        return new CustomArray(id, arr);
    }

}
