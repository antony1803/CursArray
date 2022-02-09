package by.kukyan.customarr.creator;

import by.kukyan.customarr.entity.CustomArray;

public class CustomArrayCreator {
    public CustomArray createArray (int ... arr){
        return new CustomArray(arr);
    }
}
