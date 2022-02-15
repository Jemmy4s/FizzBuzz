package com.leboncoin.fizzbuzz.controller;

import com.leboncoin.fizzbuzz.model.FizzBuzz;
import com.leboncoin.fizzbuzz.service.FizzbuzzService;
import com.leboncoin.fizzbuzz.util.Util;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzbuzzController {


    private final FizzbuzzService fizzbuzzService;

    public FizzbuzzController(FizzbuzzService fizzbuzzService) {
        this.fizzbuzzService = fizzbuzzService;
    }

    @GetMapping("/fizzbuzz")
    public ResponseEntity<List<String>> fizzbuzzList(@RequestParam(value = "str1", required = false ) String str1,
                                                   @RequestParam(value = "str2", required = false) String str2,
                                                   @RequestParam(value = "int1", required = false) Integer number1 ,
                                                   @RequestParam(value = "int2", required = false) Integer number2 ,
                                                   @RequestParam(value = "limit",  required = false) Integer limit){

        if(str1 == null && str2 ==null && number2 ==null && number1 ==null && limit ==null){
            return popularFizzbuzzList();
        }
        List<String> fizzbuzzlist = fizzbuzzService.createFizzBuzzList(number1, number2, str1, str2, limit);
        return ResponseEntity.ok(fizzbuzzlist);
    }
    @GetMapping("/")
    public ResponseEntity<List<String>> popularFizzbuzzList(){
        FizzBuzz fizzBuzz = fizzbuzzService.mostPopularFizzbuzz();
        return ResponseEntity.ok(fizzBuzz.calculFizzbuzz());
    }


}
