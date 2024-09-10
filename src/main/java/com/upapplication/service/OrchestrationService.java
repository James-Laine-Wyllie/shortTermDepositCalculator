package com.upapplication.service;

import com.upapplication.validator.InputValidator;
import jakarta.inject.Inject;

import java.math.BigDecimal;

public class OrchestrationService {

    @Inject
    private final InputValidator inputValidator;
    @Inject
    private final CalculatorService calculatorService;

    public OrchestrationService(InputValidator inputValidator, CalculatorService calculatorService) {
        this.inputValidator = inputValidator;
        this.calculatorService = calculatorService;
    }

    // Method
    public void calculateAmountWithInterest(String[] args) {

        // Take the input and validate
        boolean isInputValid = inputValidator.validateInput(args);

        if(!isInputValid) {
            System.exit(1);
        }

        // convert the values
        Double principal= inputValidator.convertStringToDouble(args[0]);
        Double rate= inputValidator.convertStringToDouble(args[1]);
        Integer timeInMonths = inputValidator.convertStringToInteger(args[2]);

        // Calculate the value
        BigDecimal amountWithInterest = calculatorService.calculateAmountWithInterest(principal, rate, timeInMonths);

        // Output to terminal
        System.out.printf("Total amount with interest: %s%n", amountWithInterest);
    }
}
