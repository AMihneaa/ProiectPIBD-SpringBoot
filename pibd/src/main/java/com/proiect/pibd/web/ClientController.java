package com.proiect.pibd.web;

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
        return "/client/index";
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


    @GetMapping("/{clientID}/update")
    public String updateClient(@PathVariable int clientID, Model model){
       Client client = clientService.getClientById(clientID);

        model.addAttribute("first_name", client.getFirstName());
        model.addAttribute("last_name", client.getLastName());
        model.addAttribute("address", client.getAddress());
        model.addAttribute("phone_number", client.getPhoneNumber());
        model.addAttribute("email", client.getEmail());


        return "/client/update";
    }

    @PostMapping("/{clientID}/save")
    public String updateClientById(@PathVariable int clientID,
                                     @RequestParam String first_name,
                                     @RequestParam String last_name,
                                     @RequestParam String address,
                                     @RequestParam String phone_number,
                                     @RequestParam String email){

        Client client = clientService.getClientById(clientID);

        client.setFirstName(first_name);
        client.setLastName(last_name);
        client.setAddress(address);
        client.setPhoneNumber(phone_number);
        client.setEmail(email);

        clientService.saveClient(client);

        return "redirect:/client";
    }
}
