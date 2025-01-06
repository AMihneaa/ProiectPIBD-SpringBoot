package com.proiect.pibd.web;

import com.proiect.pibd.domain.advocate.Advocate;
import com.proiect.pibd.domain.cases.Case;
import com.proiect.pibd.domain.client.Client;
import com.proiect.pibd.service.AdvocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/advocates")
public class AdvocateController {

    @Autowired
    private AdvocateService advocateService;

    @GetMapping("")
    public String index(Model model) {
        List<Advocate> advocates = advocateService.getAllAdvocates();
        model.addAttribute("advocatesIndex", advocates);
        return "advocatesIndex";
    }

    @GetMapping("/{advocateID}/clients")
    public String getClientsByAdvocateId(@PathVariable int advocateID, Model model) {
        List<Client> clients = advocateService.getClientsByAdvocateId(advocateID);
        Advocate advocate = advocateService.getAdvocateByID(advocateID);
        model.addAttribute("advocateClient", clients);
        model.addAttribute("advocateName", advocate.getFirstName() + " " + advocate.getLastName());
        model.addAttribute("advocateID", advocate.getAdvocateID());
        return "advocateClient";
    }

    @GetMapping("/{id}")
    public Advocate getAdvocateById(@PathVariable int id) {
        return advocateService.getAdvocateByID(id);
    }

    @PostMapping("/create")
    public String createAdvocate(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam String email,
                                   @RequestParam String phoneNumber,
                                   @RequestParam String specialty) {
        advocateService.createAdvocate(firstName, lastName, email, phoneNumber, specialty);
        return "redirect:/advocates";
    }

    @PostMapping("/{id}")
    public String deleteAdvocate(@PathVariable int id) {
        advocateService.deleteAdvocate(id);
        return "redirect:/advocates";
    }

    @GetMapping("/{advocateID}/cases")
    public String getCasesByAdvocateId(@PathVariable int advocateID, Model model) {
        List<Case> cases = advocateService.getCasesByAdvocateId(advocateID);
        Advocate advocate = advocateService.getAdvocateByID(advocateID);
        model.addAttribute("advocateCases", cases);
        model.addAttribute("advocateName", advocate.getFirstName() + " " + advocate.getLastName());
        return "advocateCase";
    }

    @PostMapping("/{advocateID}/clients/add")
    public String addClientToAdvocate(@PathVariable int advocateID, @RequestParam int clientID) {
        advocateService.addClientToAdvocate(advocateID, clientID);
        return "redirect:/advocates/" + advocateID + "/clients";
    }

    @PostMapping("/{advocateID}/clients/delete")
    public String deleteClientFromAdvocate(@PathVariable int advocateID, @RequestParam int clientID) {
        advocateService.deleteClientFromAdvocate(advocateID, clientID);
        return "redirect:/advocates/" + advocateID + "/clients";
    }

    @PostMapping("/{advocateID}/cases/remove")
    public String removeCaseFromAdvocate(@PathVariable int advocateID, @RequestParam int caseID) {
        advocateService.removeCaseFromAdvocate(advocateID, caseID);
        return "redirect:/advocates/" + advocateID + "/cases";
    }

    @PostMapping("/{advocateID}/cases/add")
    public String addCaseToAdvocate(@PathVariable int advocateID, @RequestParam int caseID) {
        advocateService.addCaseToAdvocate(advocateID, caseID);
        return "redirect:/advocates/" + advocateID + "/cases";
    }
}
