package com.proiect.pibd.service;

import com.proiect.pibd.domain.advocate.Advocate;
import com.proiect.pibd.domain.advocate.AdvocateRepository;
import com.proiect.pibd.domain.advocate_client.AdvocateClientRepository;
import com.proiect.pibd.domain.client.Client;
import com.proiect.pibd.domain.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdvocateClientRepository advocateClientRepository;

    public List<Client> getAllClient(){
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClientById(int id) {
        // Delete related data from AdvocateClient
        advocateClientRepository.deleteByClientId(id);
        // Delete the client
        clientRepository.deleteById(id);
    }
}
