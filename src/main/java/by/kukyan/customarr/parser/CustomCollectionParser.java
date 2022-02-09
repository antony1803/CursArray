package by.kukyan.customarr.parser;

import by.kukyan.customarr.exception.CustomParseException;

public interface CustomCollectionParser {
    int[] parseStringToArrayOfInts(String str) throws CustomParseException;
}
