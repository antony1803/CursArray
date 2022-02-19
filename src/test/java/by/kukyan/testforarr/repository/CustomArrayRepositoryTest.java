package by.kukyan.testforarr.repository;

import by.kukyan.customarr.comparator.CustomArrayComparator;
import by.kukyan.customarr.creator.CustomArrayCreator;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Impl.CustomArrayRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CustomArrayRepositoryTest {
    @Test
    public void sort(){
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArray first = CustomArrayCreator.createArray(2, 1, 1, 1, 1);
        CustomArray second = CustomArrayCreator.createArray(1, 2, 2, 2, 2);
        CustomArray third = CustomArrayCreator.createArray(3, 2, 2, 2, 2);
        ArrayList<CustomArray> sortedArrays = new ArrayList<>();
        sortedArrays.add(first);
        sortedArrays.add(second);
        sortedArrays.add(third);
        repository.addArray(second);
        repository.addArray(first);
        repository.addArray(third);
        var actual = repository.sort(new CustomArrayComparator());
        Assert.assertEquals(actual, sortedArrays);
    }
}
