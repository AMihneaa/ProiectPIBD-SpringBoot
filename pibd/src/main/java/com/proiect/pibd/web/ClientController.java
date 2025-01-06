package com.proiect.pibd.web;

import com.proiect.pibd.domain.advocate.Advocate;
import com.proiect.pibd.domain.client.Client;
import com.proiect.pibd.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public String index(Model model) {
        List<Client> clients = clientService.getAllClient();
        model.addAttribute("clientsIndex", clients);
        return "clientsIndex";
    }

    @PostMapping("/create")
    public String createClient(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String email,
                               @RequestParam String phoneNumber,
                               @RequestParam String address) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setAddress(address);
        clientService.saveClient(client);
        return "redirect:/client";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable int id) {
        clientService.deleteClientById(id);
        return "redirect:/client";
    }

}
