package by.kukyan.customarr.parser.impl;

import by.kukyan.customarr.parser.CustomCollectionParser;

public class CustomArrayParser implements CustomCollectionParser{

    @Override
    public int[] parseStringToArrayOfInts(String str) {
        if(str.isBlank()){
            return new int[0];
        }
        String[] arrOfNumbersInString = str.split("\\s");
        int[] result = new int[arrOfNumbersInString.length];
        for(int i = 0; i<arrOfNumbersInString.length; i++){
            result[i]= Integer.parseInt(arrOfNumbersInString[i]);
        }
        return result;
    }
}
