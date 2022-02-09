package by.kukyan.testforarr.parser;

import by.kukyan.customarr.parser.impl.CustomArrayParser;
import by.kukyan.customarr.entity.CustomArray;
import by.kukyan.customarr.exception.CustomParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.fail;

public class CustomArrayParserTest {
    private static final String CORRECT_VALUE_TO_ARRAY = "12 23 -45 56 -86 90";
    private static final String WRONG_VALUE_TO_ARRAY = " 67 qhk, !@ 67";
    CustomArrayParser arrayParser;
    @BeforeMethod
    public void setUp(){
        arrayParser = new CustomArrayParser();
    }
    @Test
    public void testCustomArrayParser(){
        CustomArray expected = new CustomArray(12, 23, -45, 56, -86, 90);
        int[] temp = null;
        try{
            temp = arrayParser.parseStringToArrayOfInts(CORRECT_VALUE_TO_ARRAY);
        }
        catch (CustomParseException e){
            fail("cant read");
        }

        Assert.assertEquals(temp, expected.getArray());
    }
    @Test(expectedExceptions = CustomParseException.class)
    public void testParseValueException() throws CustomParseException {
        arrayParser.parseStringToArrayOfInts(WRONG_VALUE_TO_ARRAY);
    }
}
