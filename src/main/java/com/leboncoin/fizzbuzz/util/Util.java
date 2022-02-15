package com.leboncoin.fizzbuzz.util;

import com.leboncoin.fizzbuzz.model.FizzBuzz;

public class Util {
    public static final String DEFAULT_STRING1 = "fizz";
    public static final String DEFAULT_STRING2 = "buzz";
    public static final Integer DEFAULT_LIMIT = 100;
    public static final Integer DEFAULT_NUMBER_STRING1 = 3;
    public static final Integer DEFAULT_NUMBER_STRING2 = 5;

    public static FizzBuzz defaultFizzBuzz(){
        return new FizzBuzz(DEFAULT_NUMBER_STRING1, DEFAULT_NUMBER_STRING2, DEFAULT_STRING1, DEFAULT_STRING2, DEFAULT_LIMIT );
    }
}
