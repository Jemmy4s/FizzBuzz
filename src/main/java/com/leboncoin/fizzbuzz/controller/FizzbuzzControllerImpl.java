package com.leboncoin.fizzbuzz.controller;

import com.leboncoin.fizzbuzz.model.FizzBuzz;
import com.leboncoin.fizzbuzz.model.FizzbuzzStatistic;
import com.leboncoin.fizzbuzz.service.FizzbuzzService;
import com.leboncoin.fizzbuzz.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FizzbuzzControllerImpl implements FizzbuzzController {


    private final FizzbuzzService fizzbuzzService;

    public FizzbuzzControllerImpl(FizzbuzzService fizzbuzzService) {
        this.fizzbuzzService = fizzbuzzService;
    }

    @Override
    @GetMapping("/fizzbuzz")
    public ResponseEntity<List<String>> fizzbuzzList(@RequestParam(value = "str1", required = false) String str1,
                                                     @RequestParam(value = "str2", required = false) String str2,
                                                     @RequestParam(value = "int1", required = false) Integer number1,
                                                     @RequestParam(value = "int2", required = false) Integer number2,
                                                     @RequestParam(value = "limit", required = false) Integer limit){

        if(limit < 0){
            List<String> error = new ArrayList<String>();
            error.add("Error limit negative");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }
        if(str1 == null && str2 ==null && number2 ==null && number1 ==null && limit ==null){
            return defaultFizzbuzz();
        }
        List<String> fizzbuzzlist = fizzbuzzService.createFizzBuzzList(number1, number2, str1, str2, limit);
        return ResponseEntity.ok(fizzbuzzlist);
    }
    @Override
    @GetMapping("/mostPopular")
    public ResponseEntity<List<String>> popularFizzbuzzList(){
        FizzBuzz fizzBuzz = fizzbuzzService.mostPopularFizzbuzzCalcul();
        return ResponseEntity.ok(fizzBuzz.calculFizzbuzz());
    }
    @GetMapping("/")
    public ResponseEntity<List<String>> defaultFizzbuzz(){
        FizzBuzz fizzBuzz = Util.defaultFizzBuzz();
        return ResponseEntity.ok(fizzBuzz.calculFizzbuzz());
    }

    @Override
    @GetMapping("/statistic")
    public ResponseEntity<List<FizzbuzzStatistic>> statistic(){
        return ResponseEntity.ok(fizzbuzzService.mostPopularFizzbuzzStatistic());
    }

}
