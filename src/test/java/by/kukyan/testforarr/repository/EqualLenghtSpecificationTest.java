package by.kukyan.testforarr.repository;

import by.kukyan.customarr.creator.CustomArrayCreator;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.repository.Impl.CustomArrayRepository;
import by.kukyan.customarr.repository.Impl.EqualLengthSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EqualLenghtSpecificationTest {
    EqualLengthSpecification specification = new EqualLengthSpecification(3);

    @Test
    public void specifyTest(){
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        CustomArray customArray = CustomArrayCreator.createArray(100000, 1, 2, 3);
        repository.addArray(customArray);
        for(int i = 5; i > 0; i--){
            CustomArray temp = CustomArrayCreator.createRandomArray(i*10, i*33);
            repository.addArray(temp);
        }
        Assert.assertEquals(customArray, repository.querry(specification).get(0));
    }
}
