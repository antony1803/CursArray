package by.kukyan.testforarr.reader;
import by.kukyan.customarr.exception.CustomReadException;
import by.kukyan.customarr.reader.impl.CustomArrayReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.fail;

public class CustomArrayReaderTest {
    private static final String EMPTY_FILE = "data/empty_file.txt";
    private static final String INVALID_FILE = "data/invalid_format.txt";
    private static final String FIRST_FILE = "data/arr1.txt";
    private static final String SECOND_FILE = "data/arr2.txt";

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
    @Test(expectedExceptions = CustomReadException.class)
    public void testReadFileException() throws CustomReadException {
        arrayReader.readCollectionFromFile(INVALID_FILE);
    }


}
