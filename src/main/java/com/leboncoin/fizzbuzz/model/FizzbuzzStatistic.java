package com.leboncoin.fizzbuzz.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class FizzbuzzStatistic {

    @Id
    @GeneratedValue
    private Long id;
    private Long nbOcurrence;

    @OneToOne
    @JoinColumn
    private FizzBuzz fizzBuzz;

    public FizzbuzzStatistic(Long nbOcurrence, FizzBuzz fizzBuzz){
        this.nbOcurrence = nbOcurrence;
        this.fizzBuzz = fizzBuzz;
    }


    public FizzbuzzStatistic() {

    }

    public void addOneOccurrence(){
        this.nbOcurrence = nbOcurrence +1L ;
    }

    public FizzBuzz getFizzBuzz(){
        return fizzBuzz;
    }
}
