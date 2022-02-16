package by.kukyan.customarr.entity;

import by.kukyan.customarr.observer.CustomCollectionObserver;
import by.kukyan.customarr.observer.impl.CustomArrayEvent;
import by.kukyan.customarr.observer.impl.CustomArrayObserver;

import java.util.Arrays;
import java.util.OptionalInt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArray extends CustomCollection{

    private static final Logger logger = LogManager.getLogger();
    public CustomArray(){
        super();
    };
    public CustomArray(int newId, int ... arr){
        super(newId);
        array = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public int [] getArray(){

        return Arrays.copyOf(array, array.length);
    }
    @Override
    public void setArray(int ... arr){
        array = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public void setElement(int place, int element) {
        if(place>= array.length|| place<0){
            return;
        }
        array[place] = element;
    }

    @Override
    public OptionalInt getElement(int place) {

        if (place >= array.length || place < 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(array[place]);
    }

    public int getArrayLength(){
        return array.length;
    }

    @Override
    public void setId(int newId) {
        id = newId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public CustomCollectionObserver getCustomArrayObserver() {
        return customCollectionObserver;
    }



    @Override
    public void setCustomArrayObserver(CustomCollectionObserver newCustomArrayObserver) {
        customCollectionObserver = newCustomArrayObserver;
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(array);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        CustomArray otherArray = (CustomArray) obj;
        if (!Arrays.equals(otherArray.array, this.array))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("CustomArray{ array = ");
        str.append(Arrays.toString(array));
        str.append("}");
        return str.toString();
    }

    @Override
    public void attach(CustomCollectionObserver observer) {
        if(customCollectionObserver == null){
            customCollectionObserver = observer;
        } else {
            logger.error("observer already used");
        }
    }

    @Override
    public void detach(CustomCollectionObserver observer) {
        if(customCollectionObserver != null){
            customCollectionObserver = null;
        } else {
            logger.error("observer not used");
        }
    }

    @Override
    public void notifyObserver() {
        CustomArrayEvent event = new CustomArrayEvent(this);
        if (customCollectionObserver != null) {
            customCollectionObserver.replaceStatistic(event);
            customCollectionObserver.updateAvg(event);
            customCollectionObserver.updateSum(event);
            customCollectionObserver.updateMax(event);
            customCollectionObserver.updateMin(event);
        }
    }
}

