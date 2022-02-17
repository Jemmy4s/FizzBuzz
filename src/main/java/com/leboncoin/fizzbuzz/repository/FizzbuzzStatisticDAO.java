package com.leboncoin.fizzbuzz.repository;

import com.leboncoin.fizzbuzz.model.FizzbuzzStatistic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FizzbuzzStatisticDAO extends JpaRepository<FizzbuzzStatistic, Long>,
        JpaSpecificationExecutor<FizzbuzzStatistic>{

    @Query("select fs from FizzbuzzStatistic fs ORDER BY fs.nbOccurrence desc")
    List<FizzbuzzStatistic> findFirstByOderByNbOcurrence(Pageable pageable);

    @Query("select fs from FizzbuzzStatistic fs  where fs.fizzBuzz.id = ?1")
    Optional<FizzbuzzStatistic> findFizzbuzzStatisticByFizzbuzzID(Long FizzbuzzID);



}
