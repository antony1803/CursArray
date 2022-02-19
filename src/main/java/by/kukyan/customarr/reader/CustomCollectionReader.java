package by.kukyan.customarr.reader;

import by.kukyan.customarr.exception.CustomReadException;

import java.util.ArrayList;

public interface CustomCollectionReader {
    String readCollectionFromFile(String path) throws CustomReadException;
    ArrayList<String> readAllCollectionsFromFile(String path) throws CustomReadException;
}
