package com.upapplication.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private InputValidator subject;

    @BeforeEach
    void setUp() {
        subject = new InputValidator();
    }

    @Test
    void validateInputReturnsTrue_whenInputValid() {
        // GIVEN
        String[] validInput = new String[]{"10000", "1.10", "9"};
        // WHEN
        boolean result = subject.validateInput(validInput);
        // THEN
        assertTrue(result);
    }

    @Test
    void validateInputReturnsFalse_whenInputArgumentLengthNotThree() {
        // GIVEN
        String[] invalidInput = new String[]{"10000", "1.10"};
        // WHEN
        boolean result = subject.validateInput(invalidInput);
        // THEN
        assertFalse(result);
    }

    @Test
    void validateInputReturnsFalse_whenInputArgumentIsHelpFlag() {
        String[] invalidInput = new String[]{"-h"};

        boolean result = subject.validateInput(invalidInput);

        assertFalse(result);
    }

    @Test
    void validateInputThrowsIllegalArgumentException_whenIntegerInputInNotCorrectFormat() {
        assertThrows(IllegalArgumentException.class, () -> subject.convertStringToInteger("notAnInteger"));
    }

    @Test
    void validateInputThrowsIllegalArgumentException_whenDoubleInputInNotCorrectFormat() {
        assertThrows(IllegalArgumentException.class, () -> subject.convertStringToDouble("notaDouble"));
    }

    @Test
    void validateInputThrowsIllegalArgumentException_whenIntegerInputIsLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> subject.convertStringToInteger("-5"));
    }

    @Test
    void validateInputThrowsIllegalArgumentException_whenDoubleInputLessIsThanZero() {
        assertThrows(IllegalArgumentException.class, () -> subject.convertStringToDouble("-12.73"));
    }


}