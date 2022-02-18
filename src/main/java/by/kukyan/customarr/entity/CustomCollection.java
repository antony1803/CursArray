package by.kukyan.customarr.entity;

import by.kukyan.customarr.observer.CustomArrayObservable;

import java.util.Arrays;
import java.util.OptionalInt;

public abstract class CustomCollection implements CustomArrayObservable {
    protected int[] array;
    private int id;

    public  CustomCollection(){};

    public  CustomCollection(int newId){
        id = newId;
    }

    public int[] getArray(){
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int...temp){
        array = Arrays.copyOf(temp, temp.length);
    }

    public OptionalInt getElement(int place) {

        if (place >= array.length || place < 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(array[place]);
    }

    public void setElement(int place, int element) {
        if(place >= array.length|| place<0){
            return;
        }
        array[place] = element;
    }

    public void setId(int newId){
        id = newId;
    }

    public int getId(){
        return id;
    }

}
