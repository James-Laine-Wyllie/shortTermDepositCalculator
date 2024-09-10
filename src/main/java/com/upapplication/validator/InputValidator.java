package com.upapplication.validator;

public class InputValidator implements Validator {

    @Override
    public boolean validateInput(String[] args) {

        if(args.length == 1 && args[0].equals("-h")) {
            printHelp();
            return false;
        }

        if(args.length != 3) {
            System.out.println("Invalid number of arguments.");
            printHelp();
            return false;
        }

        return true;
    }

    @Override
    public Integer convertStringToInteger(String input) {
        try {
            Integer value = Integer.valueOf(input);
            checkValueIsNotLessThanOrEqualZero(value);
            return value;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: " + input + ". Expecting representation of an integer.");
        }
    }

    @Override
    public Double convertStringToDouble(String input) {
        try {
            Double value = Double.valueOf(input);
            checkValueIsNotLessThanOrEqualZero(value);
            return value;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: " + input + ". Expecting a representation of a number.");
        }
    }

    private void checkValueIsNotLessThanOrEqualZero(Integer value) {
        if(value.compareTo(0) < 0) {
            throw new IllegalArgumentException("Input value can not be less than or equal to 0.");
        }
    }

    private void checkValueIsNotLessThanOrEqualZero(Double value) {
        if(value.compareTo(0.00) < 0) {
            throw new IllegalArgumentException("Input value can not be less than or equal to 0.");
        }
    }


    private void printHelp() {
        System.out.println("Usage: java -jar term-deposit-calculator.jar <principal> <rate> <time in months>");
        System.out.println("Example: java -jar term-deposit-calculator.jar 10000 1.10 9");
        System.out.println("Principal: Specified in dollars");
        System.out.println("Rate: Specified as a percentage");
        System.out.println("Time: Specified in months");
        System.out.println("Output: The total amount with interest to the nearest cent");
        System.out.println("Options:");
        System.out.println("  -h : Display this help message");
    }
}
