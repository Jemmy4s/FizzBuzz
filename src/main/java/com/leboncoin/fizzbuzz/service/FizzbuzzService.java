package com.leboncoin.fizzbuzz.service;

import com.leboncoin.fizzbuzz.model.FizzBuzz;
import com.leboncoin.fizzbuzz.model.FizzbuzzStatistic;

import java.util.List;

public interface FizzbuzzService {
    void allFizzbuzz();

    FizzbuzzStatistic getMostPopularFizzbuzzID();

    FizzBuzz mostPopularFizzbuzzCalcul();

    List<FizzbuzzStatistic> mostPopularFizzbuzzStatistic();

    List<String> createFizzBuzzList(Integer number1, Integer number2, String string1, String string2, Integer limit);
}
