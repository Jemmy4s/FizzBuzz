package com.leboncoin.fizzbuzz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
public class FizzBuzz{
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty
    Integer number1;
    @JsonProperty
    Integer number2;
    @JsonProperty
    String  string1;
    @JsonProperty
    String  string2;
    @JsonProperty
    Integer limitInt;
    private static final Integer startNumber = 1;

    public FizzBuzz() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FizzBuzz(int number1, int number2, String string1, String string2, int limitInt) {
        this.limitInt = limitInt;
        this.number1 = number1;
        this.number2 = number2;
        this.string1= string1;
        this.string2 = string2;
    }



    public List<String> calculFizzbuzz(){
        List<String> listFizzbuzzString = new LinkedList<>();
        for(int i = startNumber; i <= limitInt; i++){
            StringBuilder fizzBuzzStringBuilder = new StringBuilder() ;
            if(i % number1 == 0){
                fizzBuzzStringBuilder.append(string1);
            }
            if(i % number2 == 0){
                fizzBuzzStringBuilder.append(string2);
            }
            if(fizzBuzzStringBuilder.isEmpty()){
                fizzBuzzStringBuilder.append(i);
            }
            listFizzbuzzString.add(fizzBuzzStringBuilder.toString());
        }
        return listFizzbuzzString;
    }
}
