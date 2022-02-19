package by.kukyan.customarr.entity;

import by.kukyan.customarr.observer.CustomCollectionObserver;
import by.kukyan.customarr.observer.impl.CustomArrayEvent;
import by.kukyan.customarr.observer.impl.CustomArrayObserver;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArray extends CustomCollection{
    private static final Logger logger = LogManager.getLogger();
    private CustomArrayObserver customArrayObserver;

    public CustomArray(){
        super();
    };
    public CustomArray(int newId, int ... arr){
        super(newId);
        array = Arrays.copyOf(arr, arr.length);
    }

    public int getArrayLength(){
        return array.length;
    }


    @Override
    public int hashCode(){
        return Arrays.hashCode(array);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null) return false;
        if (getClass() != obj.getClass()) return false;
        CustomArray otherArray = (CustomArray) obj;
        if (!(Arrays.equals(otherArray.array, array) && otherArray.getId() == getId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("CustomArray{ id = ");
        str.append(getId());
        str.append(", array = ");
        str.append(Arrays.toString(array));
        str.append("}");
        return str.toString();
    }

    @Override
    public void attach(CustomCollectionObserver observer) {
        if(customArrayObserver == null){
            customArrayObserver = (CustomArrayObserver)observer;
        } else {
            logger.error("Observer had been attached already");
        }
    }

    @Override
    public void detach(CustomCollectionObserver observer) {
        if(customArrayObserver != null){
            customArrayObserver = null;
        } else {
            logger.error("Observer hab not been used");
        }
    }

    @Override
    public void notifyObserver() {
        CustomArrayEvent event = new CustomArrayEvent(this);
        if (customArrayObserver != null) {
            customArrayObserver.replaceStatistic(event);
            customArrayObserver.updateAvg(event);
            customArrayObserver.updateSum(event);
            customArrayObserver.updateMax(event);
            customArrayObserver.updateMin(event);
        }
    }

    public CustomArrayObserver getCustomCollectionObserver(){
        return customArrayObserver;
    }

    public void setCustomArrayObserver(CustomArrayObserver newCustomCollectionObserver){
        customArrayObserver = newCustomCollectionObserver;
    }

}

