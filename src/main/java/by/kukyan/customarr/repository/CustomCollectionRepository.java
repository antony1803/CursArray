package by.kukyan.customarr.repository;

import by.kukyan.customarr.entity.CustomArray;

import java.util.Comparator;
import java.util.List;

public interface CustomCollectionRepository {
    void addArray(CustomArray customArray);
    void addAllArrays(List<CustomArray> customArrays);
    void removeArray (CustomArray customArray);
    void removeAllArrays(List<CustomArray> customArrays);
    CustomArray get(int index);
    void set(int index, CustomArray customArray);
    List<CustomArray> querry(Specification specification);
    List<CustomArray> sort(Comparator<CustomArray> comparator);
}
