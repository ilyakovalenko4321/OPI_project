package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class InputCheckTest {

    @Test
    void checkLanguage(){

        String checkString = "проверка";
        boolean expectation = true;
        boolean result = InputCheck.checkLanguage(checkString);
        assertEquals(expectation, result);


        String checkStringFalse = "test";
        boolean expectationFalse = true;
        boolean resultFalse = InputCheck.checkLanguage(checkStringFalse);
        assertEquals(expectationFalse, resultFalse);

    }

}
