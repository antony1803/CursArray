package by.kukyan.customarr.validator.impl;

import by.kukyan.customarr.validator.CustomColectionValidator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CustomArrayValidator implements CustomColectionValidator {
    private static CustomColectionValidator instance;

    @Override
    public boolean validateArray(String array) {
       Pattern pattern = Pattern.compile(REGEX_FOR_ARRAY_VALIDATION);
       Matcher matcher = pattern.matcher(array);
       return matcher.matches();
    }

    public static CustomColectionValidator getInstance() {
        return (instance == null?new CustomArrayValidator():instance);
    }
}
