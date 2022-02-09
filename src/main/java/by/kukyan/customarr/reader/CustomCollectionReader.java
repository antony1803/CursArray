package by.kukyan.customarr.reader;

import by.kukyan.customarr.exception.CustomCollectionExcepion;

public interface CustomCollectionReader {
    String readCollectionFromFile(String path) throws CustomCollectionExcepion;
    String[] readAllCollectionsFromFile(String path) throws CustomCollectionExcepion;
}
