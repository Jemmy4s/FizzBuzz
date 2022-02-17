package com.leboncoin.fizzbuzz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FizzbuzzController {
    @GetMapping("/fizzbuzz")
    ResponseEntity<List<String>> fizzbuzzList(@RequestParam(value = "str1", required = false) String str1,
                                              @RequestParam(value = "str2", required = false) String str2,
                                              @RequestParam(value = "int1", required = false) Integer number1,
                                              @RequestParam(value = "int2", required = false) Integer number2,
                                              @RequestParam(value = "limit", required = false) Integer limit);

    @GetMapping("/")
    ResponseEntity<List<String>> popularFizzbuzzList();

    @GetMapping("/statistic")
    ResponseEntity<List<Object>> statistic();
}
