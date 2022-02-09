package by.kukyan.customarr.reader;

import by.kukyan.customarr.exception.CustomReadException;

public interface CustomCollectionReader {
    String readCollectionFromFile(String path) throws CustomReadException;
    String[] readAllCollectionsFromFile(String path) throws CustomReadException;
}
