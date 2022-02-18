package by.kukyan.customarr.parser;

import by.kukyan.customarr.exception.CustomParseException;

public interface CustomCollectionParser {
    String LIMITATION_REGEX = "\\s";
    int[] parseStringToArrayOfInts(String str) throws CustomParseException;
}
