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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.leboncoin.fizzbuzz.util.Util.*;

@Service
public class FizzbuzzServiceImpl implements FizzbuzzService {

   private final FizzbuzzDAO fizzbuzzDAO;
   private final FizzbuzzStatisticDAO fizzbuzzStatisticDAO;

   @Autowired
    public FizzbuzzServiceImpl(FizzbuzzDAO fizzbuzzDAO, FizzbuzzStatisticDAO fizzbuzzStatisticDAO) {
        this.fizzbuzzDAO = fizzbuzzDAO;
        this.fizzbuzzStatisticDAO = fizzbuzzStatisticDAO;
    }

    @Override
    public  void allFizzbuzz() {
       fizzbuzzDAO.findAll();
    }

    @Override
    public FizzbuzzStatistic getMostPopularFizzbuzzID(){
        List<FizzbuzzStatistic> fizzbuzzStatistic =  fizzbuzzStatisticDAO.findFirstByOderByNbOcurrence(PageRequest.of(0,1));
        if(fizzbuzzStatistic.isEmpty()){
            return null;
        }
        return fizzbuzzStatistic.get(0);
    }


    @Override
    public FizzBuzz mostPopularFizzbuzzCalcul(){
        FizzbuzzStatistic fizzbuzzStatistic =  getMostPopularFizzbuzzID();
        Optional<FizzBuzz> fizzBuzz = fizzbuzzDAO.findById(fizzbuzzStatistic.getFizzBuzz().getId());
        if(fizzBuzz.isEmpty()){
            return defaultFizzBuzz();
        }else {
            return fizzBuzz.get();
        }
    }

    @Override
    public List<FizzbuzzStatistic> mostPopularFizzbuzzStatistic(){
        FizzbuzzStatistic fizzbuzzStatistic =  getMostPopularFizzbuzzID();
        List<FizzbuzzStatistic> objectsList= new ArrayList<>();
        if(fizzbuzzStatistic == null){
            return objectsList;
        }
        Optional<FizzBuzz> fizzBuzz = fizzbuzzDAO.findById(fizzbuzzStatistic.getFizzBuzz().getId());
        objectsList.add(fizzbuzzStatistic);
        return objectsList;
    }

    @Override
    public List<String> createFizzBuzzList(Integer number1, Integer number2, String string1, String string2, Integer limit) {
       FizzBuzzBuilder fizzBuzzBuilder=  FizzBuzzBuilder.aFizzBuzz().withLimit(limit)
                .withNumber1(number1)
                .withNumber2(number2)
                .withString1(string1)
                .withString2(string2);

       FizzBuzz fizzBuzz = fizzBuzzBuilder.build();
       createFizzbuzz(fizzBuzz);


       return fizzBuzz.calculFizzbuzz();
    }
    public Example<FizzBuzz> fizzBuzzExample(FizzBuzz fizzBuzz){
        ExampleMatcher fizzBuzzMatcher = ExampleMatcher.matching().withIgnorePaths("id");
         return Example.of(fizzBuzz,fizzBuzzMatcher);
    }
    public void createFizzbuzz(FizzBuzz fizzBuzz){
        FizzBuzz fizzBuzzWithId;
        Example<FizzBuzz> fizzBuzzExample = fizzBuzzExample(fizzBuzz);
        Optional<FizzBuzz> optionalFizzBuzz = fizzbuzzDAO.findOne(fizzBuzzExample);
        if(optionalFizzBuzz.isEmpty()) {
            fizzBuzzWithId = fizzbuzzDAO.save(fizzBuzz);
            fizzbuzzStatisticDAO.save(new FizzbuzzStatistic());
        } else {
            fizzBuzzWithId = optionalFizzBuzz.get();
            Optional<FizzbuzzStatistic> optionalStatistic = fizzbuzzStatisticDAO.findFizzbuzzStatisticByFizzbuzzID(fizzBuzzWithId.getId());
            FizzbuzzStatistic statistic= (optionalStatistic.isEmpty()) ?  new FizzbuzzStatistic(1L,fizzBuzzWithId) : optionalStatistic.get();
            statistic.addOneOccurrence();
            fizzbuzzStatisticDAO.save(statistic);
        }

    }
}

