package com.upapplication.service;

import com.upapplication.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OrchestrationServiceTest {

    @Mock
    private InputValidator inputValidator;
    @Mock
    private CalculatorService calculatorService;

    private OrchestrationService subject;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        subject = new OrchestrationService(inputValidator, calculatorService);

        when(inputValidator.validateInput(any())).thenReturn(true);
        when(inputValidator.convertStringToDouble(anyString())).thenReturn(Double.valueOf("1"));
        when(inputValidator.convertStringToDouble(anyString())).thenReturn(Double.valueOf("1"));
        when(inputValidator.convertStringToInteger(anyString())).thenReturn(Integer.valueOf("1"));
        when(calculatorService.calculateAmountWithInterest(any(), any(), any())).thenReturn(BigDecimal.ONE);

    }

    @Test
    void shouldCalculateAmountWithInterest() {
        String[] validInput = new String[]{"10000", "1.10", "9"};

        assertDoesNotThrow(() -> subject.calculateAmountWithInterest(validInput));
    }
}