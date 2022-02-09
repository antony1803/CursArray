package by.kukyan.customarr.entity;

import java.util.Arrays;

public class CustomArray extends CustomCollection{
    private int [] array;
    public CustomArray(int ... arr){

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
    public int getElement(int place) {
        if(place>= array.length|| place<0){
            return 0;
        }
        return array[place];
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
}

