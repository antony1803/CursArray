package by.kukyan.customarr.entity;

import by.kukyan.customarr.observer.CustomArrayObservable;
import by.kukyan.customarr.observer.CustomCollectionObserver;
import by.kukyan.customarr.observer.impl.CustomArrayObserver;

import java.util.OptionalInt;

public abstract class CustomCollection implements CustomArrayObservable {
    protected int[] array;
    protected int id;
    public  CustomCollection(){};
    public  CustomCollection(int newId){
        id = newId;
    }
    protected CustomCollectionObserver customCollectionObserver;
    public abstract int[] getArray();
    public abstract void setArray(int...array);
    public abstract  void setElement(int place, int element);
    public abstract OptionalInt getElement(int place);
    public abstract void setId(int newId);
    public abstract int getId();
    public abstract CustomCollectionObserver getCustomArrayObserver();
    public abstract void setCustomArrayObserver(CustomCollectionObserver customArrayObserver);
}
