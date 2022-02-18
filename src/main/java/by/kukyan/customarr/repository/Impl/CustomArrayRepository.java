package by.kukyan.customarr.repository.Impl;

import by.kukyan.customarr.comparator.CustomArrayComparatorById;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Specification;
import by.kukyan.customarr.repository.CustomCollectionRepository;

import java.util.*;
import java.util.stream.Collectors;

public class CustomArrayRepository implements CustomCollectionRepository {
    private static CustomArrayRepository instance;
    private List<CustomArray> arrays;

    public CustomArrayRepository() {
        arrays = new ArrayList<>();
    }

    public static CustomArrayRepository getInstance(){
        if(instance == null){
            instance = new CustomArrayRepository();
        }
        return instance;
    }

    public int getSize(){
        return arrays.size();
    }

    @Override
    public void addArray(CustomArray arrayEntity) {
        arrays.add(arrayEntity);
    }

    @Override
    public void addAllArrays(List<CustomArray> arrayEntities) {
        arrays.addAll(arrayEntities);
    }

    @Override
    public void removeArray(CustomArray arrayEntity) {
        arrays.remove(arrayEntity);
    }

    @Override
    public void removeAllArrays(List arrayEntities) {
        arrays.removeAll(arrayEntities);
    }

    @Override
    public CustomArray get(int index) {
        return arrays.get(index);
    }

    @Override
    public void set(int index, CustomArray customArray) {
        arrays.set(index, customArray);
    }

    @Override
    public List<CustomArray> querry(Specification specification) {
        List<CustomArray> list = arrays.stream().
                filter(specification::specify).
                collect(Collectors.toList());
        return list;
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        List<CustomArray> list = arrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return list;
    }
}
