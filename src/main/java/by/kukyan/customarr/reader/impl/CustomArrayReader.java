package by.kukyan.customarr.reader.impl;

import by.kukyan.customarr.exception.CustomReadException;
import by.kukyan.customarr.reader.CustomCollectionReader;
import by.kukyan.customarr.validator.impl.CustomArrayValidator;
import by.kukyan.customarr.validator.CustomColectionValidator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CustomArrayReader implements CustomCollectionReader{

    private static  final Logger log = LogManager.getLogger();

    @Override
    public String readCollectionFromFile(String path) throws CustomReadException {
        log.info("trying to read the \"{}\" file", path);
        File file = new File(path);
        if (file.exists()&&file.length()==0){
            return "";
        }
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            CustomColectionValidator validator = CustomArrayValidator.getInstance();

            String str = "";
            while((str = bufferedReader.readLine())!=null)
            {
                return str;
            }
        }
        catch (IOException e){
            log.error(e.getMessage());
            throw new CustomReadException(e);
        }
        log.error("Invalid format of the file " + path);
        throw new CustomReadException("Invalid format of the file "+ path);
    }

    @Override
    public String[] readAllCollectionsFromFile(String path) throws CustomReadException {
        File file = new File(path);
        if (file.exists() && file.length() == 0) {
            return new String[]{};
        }
        String finalArrString[] = new String[]{};
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            CustomColectionValidator validator = CustomArrayValidator.getInstance();
            finalArrString = bufferedReader.lines().filter(validator::validateArray).toArray(String[]::new);

        } catch (IOException e) {
            log.error(e.getMessage());
            throw new CustomReadException(e);
        }

        if (finalArrString.length != 0) {
            return finalArrString;
        } else {
            log.error("Invalid format of the file " + path);
            throw new CustomReadException("Invalid format of the file " + path);
        }
    }
}
