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
import java.util.ArrayList;
import java.util.List;

public class CustomArrayReader implements CustomCollectionReader{

    private static  final Logger log = LogManager.getLogger();

    @Override
    public String readCollectionFromFile(String path) throws CustomReadException {
        log.info("trying to read the \"{}\" file", path);
        File file = new File(path);
        if (file.exists() && file.length()==0){
            return "";
        }
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            CustomColectionValidator validator = CustomArrayValidator.getInstance();

            String str;
            while((str = bufferedReader.readLine()) != null) {
                if(validator.validateArray(str)) {
                    return str;
                }
            }
        }catch (IOException e){
            log.error(e.getMessage());
            throw new CustomReadException(e);
        }
        log.error("Invalid format of the file " + path);
        throw new CustomReadException("Invalid format of the file "+ path);
    }

    @Override
    public ArrayList<String> readAllCollectionsFromFile(String path) throws CustomReadException {
        File file = new File(path);
        ArrayList<String> result = new ArrayList<>();
        if (file.exists() && file.length() == 0) {
            return result;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            CustomColectionValidator validator = CustomArrayValidator.getInstance();
            result.addAll(bufferedReader.lines().filter(validator::validateArray).toList());

        } catch (IOException e) {
            log.error(e.getMessage());
            throw new CustomReadException(e);
        }

        if (result.size() != 0) {
            return result;
        } else {
            log.error("Invalid format of the file " + path);
            throw new CustomReadException("Invalid format of the file " + path);
        }
    }
}
