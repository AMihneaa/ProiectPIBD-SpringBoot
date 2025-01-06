package com.proiect.pibd.domain.cases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Integer> {
    @Query("SELECT c FROM Case c WHERE c.advocateID = :advocateID")
    List<Case> findCasesByAdvocateId(@Param("advocateID") int advocateID);


    @Modifying
    @Transactional
    @Query("UPDATE Case c SET c.advocateID = null WHERE c.caseID = :caseID AND c.advocateID = :advocateID")
    void removeAdvocateFromCase(@Param("advocateID") int advocateID, @Param("caseID") int caseID);

    @Modifying
    @Transactional
    @Query("UPDATE Case c SET c.advocateID = null WHERE c.advocateID = :advocateID")
    void removeAdvocateFromCaseById(@Param("advocateID") int advocateID);


    @Modifying
    @Transactional
    @Query("UPDATE Case c SET c.advocateID = :advocateID WHERE c.caseID = :caseID")
    void addCaseToAdvocate(@Param("advocateID") int advocateID, @Param("caseID") int caseID);
}