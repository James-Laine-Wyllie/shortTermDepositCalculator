package com.upapplication;

import org.junit.jupiter.api.Test;

public class TermDepositCalculatorTest {

    @Test
    void shouldCalculateTotalAmountWithInterest_whenInputIsValid() {
        String[] validInput = new String[]{"10000", "1.10", "9"};

        TermDepositCalculator.main(validInput);
    }
}
