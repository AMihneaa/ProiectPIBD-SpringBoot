package com.proiect.pibd.domain.advocate;

import com.proiect.pibd.domain.cases.Case;
import com.proiect.pibd.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdvocateRepository  extends JpaRepository<Advocate, Integer> {

    @Query("SELECT c FROM Client c JOIN AdvocateClient ac ON c.clientID = ac.id.clientID WHERE ac.id.advocateID = :advocateID")
    List<Client> findClientsByAdvocateId(@Param("advocateID") int advocateID);

    /*
    SELECT c.first_Name, c.last_name, c.email, c.phone_number
    FROM Clients AS c
    INNER JOIN Advocate_Client AS ac ON c.ClientID = ac.ClientID
    INNER JOIN Advocates AS a ON ac.AdvocateID = a.AdvocateID
    WHERE a.AdvocateID = this.AdvocateID;
     */

}
