package com.leboncoin.fizzbuzz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class FizzbuzzStatistic {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty
    private Long nbOccurrence;

    @OneToOne
    @JoinColumn
    private FizzBuzz fizzBuzz;

    public FizzbuzzStatistic(Long nbOccurrence, FizzBuzz fizzBuzz){
        this.nbOccurrence = nbOccurrence;
        this.fizzBuzz = fizzBuzz;
    }


    public FizzbuzzStatistic() {

    }

    public void addOneOccurrence(){
        this.nbOccurrence = nbOccurrence +1L ;
    }

    public FizzBuzz getFizzBuzz(){
        return fizzBuzz;
    }


}
