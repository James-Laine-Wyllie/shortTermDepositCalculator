package com.upapplication.validator;

public interface Validator {

    boolean validateInput(String[] args);

    Integer convertStringToInteger(String input);

    Double convertStringToDouble(String input);
}
