package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMobileNumber()
    {
        int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,0};
        assertEquals("(123) 456-7890",MainActivity.createPhoneNumber(intArray));
    }

}