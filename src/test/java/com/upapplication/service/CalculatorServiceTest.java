package com.upapplication.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {

    private CalculatorService subject;

    @BeforeEach
    void setUp() {
        subject = new CalculatorService();
    }

    @Test
    void calculateAmountWithInterest() {
        // BEFORE
        double principal = 10000;
        double rate = 1.10;
        Integer time = 1;
        BigDecimal expectedAmount = BigDecimal.valueOf(10009.17);
        // WHEN
        BigDecimal result = subject.calculateAmountWithInterest(principal, rate, time);
        // THEN
        assertEquals(expectedAmount, result);
    }

    @ParameterizedTest
    @CsvSource(value={
            "1, 10009.17",
            "2, 10018.34",
            "3, 10027.53",
            "4, 10036.72",
            "5, 10045.92",
            "6, 10055.13",
            "7, 10064.34",
            "8, 10073.57",
            "9, 10082.80",
            "10, 10092.05",
            "11, 10101.30",
            "12, 10110.56"
    })
    void calculateAmountWithInterestVaryTimeInput(Integer timeInMonths, BigDecimal expectedAmount) {
        // GIVEN
        double principal = 10000;
        double rate = 1.10;
        // WHEN
        BigDecimal result = subject.calculateAmountWithInterest(principal, rate, timeInMonths);
        // THEN
        assertEquals(expectedAmount, result);
    }

    @ParameterizedTest
    @CsvSource(value={
            "1.10, 10092.05",
            "2.00, 10167.92",
            "2.50, 10210.30",
            "2.75, 10231.54",
            "5.00, 10424.57",
    })
    void calculateAmountWithInterestVaryRateInput(Double rate, BigDecimal expectedAmount) {
        // GIVEN
        double principal = 10000;
        Integer timeInMonths = 10;
        // WHEN
        BigDecimal result = subject.calculateAmountWithInterest(principal, rate, timeInMonths);
        // THEN
        assertEquals(expectedAmount, result);
    }
}