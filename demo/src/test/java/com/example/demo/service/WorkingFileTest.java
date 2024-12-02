package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
public class WorkingFileTest {

    @Test
    void CheckingCAndBTest() {
        // Define test data
        String programString = "Word";
        String userString = "Wodr";

        // Expected result (adjust based on your method's expected behavior)
        int[] expectedResult = {2, 4}; // Replace with the actual expected result

        // Call the method and get the result
        int[] result = WorkingFile.checkingCAndB(programString, userString);

        // Assert the result
        assertArrayEquals(expectedResult, result);
    }



}
