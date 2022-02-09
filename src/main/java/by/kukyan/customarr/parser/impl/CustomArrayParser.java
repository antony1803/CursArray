package by.kukyan.customarr.parser.impl;

import by.kukyan.customarr.exception.CustomParseException;
import by.kukyan.customarr.parser.CustomCollectionParser;
import by.kukyan.customarr.exception.CustomCollectionExcepion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

public class CustomArrayParser implements CustomCollectionParser{

    private static final Logger logger = LogManager.getLogger();
    @Override
    public int[] parseStringToArrayOfInts(String str) throws  CustomParseException{
        if(str.isBlank()){
            return new int[0];
        }
        String[] arrOfNumbersInString = str.split("\\s");
        int[] result = new int[arrOfNumbersInString.length];
        for(int i = 0; i<arrOfNumbersInString.length; i++){
            try{
                result[i]= Integer.parseInt(arrOfNumbersInString[i]);
            }
            catch (NumberFormatException e){
                logger.error("invalid file format", e);
                throw new CustomParseException("invalid file format");
            }
        }
        return result;
    }
}
