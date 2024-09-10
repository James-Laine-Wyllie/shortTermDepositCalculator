package com.upapplication.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorService {

    //  Compound interest equation: Value after interest = P * (1 + R/N)^(T)
    //  P: Principal, R: Rate, N: Number of times the interest is calculated, T: Time in months
    //      Notes: Interest rate is per year, so to get monthly: N is 12

    public BigDecimal calculateAmountWithInterest(Double principal, Double rate, Integer time) {
        System.out.printf("Calculating amount with inputs: principal: %s, rate: %s, time: %s%n", principal, rate, time);

        double amount = principal * (Math.pow(1 + ((rate / 100) / 12), time));
        System.out.printf("Amount: %s%n", amount);

        BigDecimal amountWithPrecision = BigDecimal
                .valueOf(amount)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.printf("Calculated amount: %s%n", amountWithPrecision);

        return amountWithPrecision;
    }

}
