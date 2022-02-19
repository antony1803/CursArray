package by.kukyan.testforarr.reader;

import by.kukyan.customarr.exception.CustomReadException;
import by.kukyan.customarr.reader.impl.CustomArrayReader;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.fail;

import java.util.ArrayList;

public class CustomArrayReaderTest {
    private static final String INVALID_FILE = "src/test/resources/invalid_format.txt";
    private static final String SECOND_FILE = "src/test/resources/data/arr2.txt";
    private static final String ARRAYS_FILE = "src/test/resources/data/arrays.txt";

    CustomArrayReader arrayReader;

    @BeforeMethod
    public void setUp(){
        arrayReader = new CustomArrayReader();
    }

    @Test
    public void testRead(){
        String expected = "12 23 6 889 4 23 -23 -98";
        String temp = null;
        try {
            temp = arrayReader.readCollectionFromFile(SECOND_FILE);
        }
        catch (CustomReadException e){
            fail("cant read", e);
        }
        Assert.assertEquals(expected, temp);
    }

    @Test
    public void testReadAll(){
        try {
            ArrayList<String> expected = new ArrayList<>();
            expected.add("9 10 6472 2 -2 1 -2");
            expected.add("673 7 9210 9");
            expected.add("");
            expected.add("67328 -29 -34 -1");
            ClassLoader classLoader = getClass().getClassLoader();
            ArrayList<String> actual = arrayReader.readAllCollectionsFromFile(ARRAYS_FILE);
            Assert.assertEquals(actual, expected);
        } catch (CustomReadException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomReadException.class)
    public void testReadFileException() throws CustomReadException {
        arrayReader.readCollectionFromFile(INVALID_FILE);
    }

    @Test(expectedExceptions = CustomReadException.class)
    public void testReadAllException() throws CustomReadException{
        arrayReader.readAllCollectionsFromFile(INVALID_FILE);
    }


}
