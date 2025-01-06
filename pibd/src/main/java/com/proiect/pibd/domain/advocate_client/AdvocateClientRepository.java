package com.proiect.pibd.domain.advocate_client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface AdvocateClientRepository extends JpaRepository<AdvocateClient, AdvocateClient.AdvocateClientId> {


    @Modifying
    @Transactional
    @Query("DELETE FROM AdvocateClient ac WHERE ac.id.clientID = :clientId")
    void deleteByClientId(@Param("clientId") int clientId);


    @Modifying
    @Transactional
    @Query("DELETE FROM AdvocateClient ac WHERE ac.id.advocateID = :advocateID")
    void deleteByAdvocateId(@Param("advocateID") int advocateId);
}
