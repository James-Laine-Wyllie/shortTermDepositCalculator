package com.upapplication;

import com.upapplication.service.CalculatorService;
import com.upapplication.service.OrchestrationService;
import com.upapplication.validator.InputValidator;

public class TermDepositCalculator {

    private static final InputValidator inputValidator = new InputValidator();
    private static final CalculatorService calculatorService = new CalculatorService();

    private static final OrchestrationService orchestrationService = new OrchestrationService(inputValidator, calculatorService);

    public static void main(String[] args) {
        orchestrationService.calculateAmountWithInterest(args);
    }
}