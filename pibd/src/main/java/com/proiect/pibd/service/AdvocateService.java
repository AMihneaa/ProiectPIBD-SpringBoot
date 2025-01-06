package com.proiect.pibd.service;

import com.proiect.pibd.domain.advocate.Advocate;
import com.proiect.pibd.domain.advocate.AdvocateRepository;
import com.proiect.pibd.domain.advocate_client.AdvocateClient;
import com.proiect.pibd.domain.advocate_client.AdvocateClientRepository;
import com.proiect.pibd.domain.cases.Case;
import com.proiect.pibd.domain.cases.CaseRepository;
import com.proiect.pibd.domain.client.Client;
import com.proiect.pibd.domain.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdvocateService {

    @Autowired
    private AdvocateRepository advocateRepository;

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private AdvocateClientRepository advocateClientRepository;
    @Autowired
    private ClientRepository clientRepository;

    public List<Advocate> getAllAdvocates(){
        List<Advocate> advocates = advocateRepository.findAll();
        System.out.println(advocates);
        return advocates;
    }

    public Advocate getAdvocateByID(int id){
        return advocateRepository.findById(id).orElse(null);
    }

    public Advocate saveAdvocate(Advocate advocate){
        return advocateRepository.save(advocate);
    }

    public void deleteAdvocate(int id){
        advocateClientRepository.deleteByAdvocateId(id);
        advocateRepository.deleteById(id);
        caseRepository.removeAdvocateFromCaseById(id);
    }

    public Advocate createAdvocate(String firstName, String lastName, String email, String phoneNumber, String Speciality){
        Advocate newAdvocate = new Advocate();
        newAdvocate.setFirstName(firstName);
        newAdvocate.setLastName(lastName);
        newAdvocate.setEmail(email);
        newAdvocate.setPhoneNumber(phoneNumber);
        newAdvocate.setSpecialty(Speciality);

        return advocateRepository.save(newAdvocate);
    }

    public List<Client> getClientsByAdvocateId(int advocateID) {
        return advocateRepository.findClientsByAdvocateId(advocateID);
    }

    public List<Case> getCasesByAdvocateId(int advocateID) {
        return caseRepository.findCasesByAdvocateId(advocateID);
    }


    public void addClientToAdvocate(int advocateID, int clientID) {
        Optional<Client> client = clientRepository.findById(clientID);

        if (!client.isPresent()){
            return ;
        }

        AdvocateClient advocateClient = new AdvocateClient(advocateID, clientID, new Date());
        advocateClientRepository.save(advocateClient);
    }

    public void deleteClientFromAdvocate(int advocateID, int clientID) {
        AdvocateClient.AdvocateClientId id = new AdvocateClient.AdvocateClientId(advocateID, clientID);
        advocateClientRepository.deleteById(id);
    }

    public void removeCaseFromAdvocate(int advocateID, int caseID) {
        caseRepository.removeAdvocateFromCase(advocateID, caseID);
    }

    public void addCaseToAdvocate(int advocateID, int caseID){
        caseRepository.addCaseToAdvocate(advocateID, caseID);
    }

}
