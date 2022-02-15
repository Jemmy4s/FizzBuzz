package com.leboncoin.fizzbuzz.util;

import com.leboncoin.fizzbuzz.model.FizzBuzz;
import static com.leboncoin.fizzbuzz.util.Util.*;

public final class FizzBuzzBuilder {
    private Integer number1;
    private Integer number2;
    private String string1;
    private String string2;
    private Integer limit;

    private FizzBuzzBuilder() {
        FizzBuzz defaultFizzBuzz = defaultFizzBuzz();
        this.string1 = DEFAULT_STRING1;
        this.string2 = DEFAULT_STRING2;
        this.number1 = DEFAULT_NUMBER_STRING1;
        this.number2 =DEFAULT_NUMBER_STRING2;
        this.limit = DEFAULT_LIMIT;
    }

    public static FizzBuzzBuilder aFizzBuzz() {
        return new FizzBuzzBuilder();
    }

    public FizzBuzzBuilder withNumber1(Integer number1) {
        if (number1 == null){
           return this;
        }
        this.number1 = number1;
        return this;
    }

    public FizzBuzzBuilder withNumber2(Integer number2) {
        if(number2 == null){
            return this;
        }
        this.number2 = number2;
        return this;
    }

    public FizzBuzzBuilder withString1(String string1) {
        if(string1 == null){
            return this;
        }
        this.string1 = string1;
        return this;
    }

    public FizzBuzzBuilder withString2(String string2) {
       if(string2 == null){
           return  this;
       }
        this.string2 = string2;
        return this;
    }

    public FizzBuzzBuilder withLimit(Integer limit) {
        if(limit == null){
            return  this;
        }
        this.limit = limit;
        return this;
    }

    public FizzBuzz build() {
        return new FizzBuzz(number1, number2, string1, string2, limit);
    }
}
