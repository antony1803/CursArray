package by.kukyan.customarr.validator;

public interface CustomColectionValidator {
    String REGEX_FOR_ARRAY_VALIDATION = "^([+-]?\\d+\\s+)*([+-]?\\d+)?$";

    boolean validateArray(String array);
}
