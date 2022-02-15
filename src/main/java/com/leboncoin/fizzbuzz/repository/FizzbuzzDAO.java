package com.leboncoin.fizzbuzz.repository;

import com.leboncoin.fizzbuzz.model.FizzBuzz;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FizzbuzzDAO extends JpaRepository<FizzBuzz, Long>,
        JpaSpecificationExecutor<FizzBuzz> {

}
