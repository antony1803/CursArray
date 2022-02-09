package by.kukyan.customarr.entity;

public abstract class CustomCollection {
    private int[] array;
    public abstract int[] getArray();
    public abstract void setArray(int...array);
    public abstract  void setElement(int place, int element);
    public abstract int getElement(int place);
}
