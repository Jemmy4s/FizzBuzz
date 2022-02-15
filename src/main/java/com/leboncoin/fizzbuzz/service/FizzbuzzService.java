package com.leboncoin.fizzbuzz.service;

import com.leboncoin.fizzbuzz.model.FizzBuzz;
import com.leboncoin.fizzbuzz.model.FizzbuzzStatistic;
import com.leboncoin.fizzbuzz.repository.FizzbuzzDAO;
import com.leboncoin.fizzbuzz.repository.FizzbuzzStatisticDAO;
import com.leboncoin.fizzbuzz.util.FizzBuzzBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.leboncoin.fizzbuzz.util.Util.*;

@Service
public class FizzbuzzService {

   private final FizzbuzzDAO fizzbuzzDAO;
   private final FizzbuzzStatisticDAO fizzbuzzStatisticDAO;

   @Autowired
    public FizzbuzzService(FizzbuzzDAO fizzbuzzDAO, FizzbuzzStatisticDAO fizzbuzzStatisticDAO) {
        this.fizzbuzzDAO = fizzbuzzDAO;
        this.fizzbuzzStatisticDAO = fizzbuzzStatisticDAO;
    }

    public  void allFizzbuzz() {
       fizzbuzzDAO.findAll();
    }

    public FizzBuzz mostPopularFizzbuzz(){
        FizzbuzzStatistic fizzbuzzStatistic =  fizzbuzzStatisticDAO.findFirstByOderByNbOcurrence(PageRequest.of(0,1)).get(0);
        Optional<FizzBuzz> fizzBuzz = fizzbuzzDAO.findById(fizzbuzzStatistic.getFizzBuzz().getId());
        if(fizzBuzz.isEmpty()){
            return defaultFizzBuzz();
        }else {
            return fizzBuzz.get();
        }
    }


    public List<String> createFizzBuzzList(Integer number1, Integer number2, String string1, String string2, Integer limit) {
       FizzBuzzBuilder fizzBuzzBuilder=  FizzBuzzBuilder.aFizzBuzz().withLimit(limit)
                .withNumber1(number1)
                .withNumber2(number2)
                .withString1(string1)
                .withString2(string2);

       FizzBuzz fizzBuzz = fizzBuzzBuilder.build();
       FizzBuzz fizzBuzzWithId = new FizzBuzz();
        ExampleMatcher fizzBuzzMatcher = ExampleMatcher.matching().withIgnorePaths("id");
        Example<FizzBuzz> fizzBuzzExample = Example.of(fizzBuzz,fizzBuzzMatcher);
       if(!fizzbuzzDAO.exists(fizzBuzzExample)) {
            fizzBuzzWithId = fizzbuzzDAO.save(fizzBuzz);
            fizzbuzzStatisticDAO.save(new FizzbuzzStatistic());
        } else {
           fizzBuzzWithId = fizzbuzzDAO.findOne(fizzBuzzExample).get();
           Optional<FizzbuzzStatistic> optionalStatistic = fizzbuzzStatisticDAO.findFizzbuzzStatisticByFizzbuzzID(fizzBuzzWithId.getId());
           FizzbuzzStatistic statistic= (optionalStatistic.isEmpty()) ?  new FizzbuzzStatistic(1L,fizzBuzzWithId) : optionalStatistic.get();
           statistic.addOneOccurrence();
           fizzbuzzStatisticDAO.save(statistic);
        }

       return fizzBuzz.calculFizzbuzz();
    }


}
