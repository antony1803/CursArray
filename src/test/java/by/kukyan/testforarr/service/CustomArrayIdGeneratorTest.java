package by.kukyan.testforarr.service;

import by.kukyan.customarr.service.impl.CustomArrayIdGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomArrayIdGeneratorTest {
    @Test
    public void getId(){
        int first_id = CustomArrayIdGenerator.getNextId();
        int second_id = CustomArrayIdGenerator.getNextId();
        Assert.assertEquals(second_id - first_id, 1);
    }
}
