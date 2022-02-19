package by.kukyan.customarr.comparator;

import by.kukyan.customarr.entity.CustomArray;

import java.util.Comparator;
import java.util.Arrays;

public class CustomArrayComparator implements Comparator<CustomArray>{

    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return Arrays.equals(o1.getArray(), o2.getArray()) ? (o1.getId()-o2.getId()) : Arrays.compare(o1.getArray(), o2.getArray());
    }
}
