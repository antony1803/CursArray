package by.kukyan.customarr.comparator;

import by.kukyan.customarr.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayComparatorById implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return o1.getId() - o2.getId();
    }
}
