package com.proiect.pibd.web;

import com.proiect.pibd.domain.advocate.Advocate;
import com.proiect.pibd.domain.cases.Case;
import com.proiect.pibd.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @GetMapping("")
    public String displayCases(Model model) {
        List<Case> cases = caseService.getAllCases();
        model.addAttribute("casesIndex", cases);
        return "/case/index";
    }

    @PostMapping("/{id}")
    public String deleteCase(@PathVariable("id") int id) {
        caseService.deleteCaseById(id);
        return "redirect:/cases";
    }

    @PostMapping("")
    public String createCase(@RequestParam String caseName, @RequestParam String caseType) {
        Case newCase = new Case();
        newCase.setCaseName(caseName);
        newCase.setCaseType(caseType);
        newCase.setDateOpened(new Date());
        newCase.setStatus("Open");
        caseService.saveCase(newCase);
        return "redirect:/cases";
    }


    @GetMapping("/{caseID}/update")
    public String updateCase(@PathVariable int caseID, Model model){
        Case cases = caseService.getCaseById(caseID);

        model.addAttribute("case_name", cases.getCaseName());
        model.addAttribute("case_type", cases.getCaseType());
        model.addAttribute("status", cases.getStatus());


        return "/case/update";
    }

    @PostMapping("/{caseID}/save")
    public String updateAdvocateByID(@PathVariable int caseID,
                                     @RequestParam String case_name,
                                     @RequestParam String case_type,
                                     @RequestParam String status){

        Case cases = caseService.getCaseById(caseID);
        cases.setStatus(status);
        cases.setCaseName(case_name);
        cases.setCaseType(case_type);

        caseService.saveCase(cases);

        return "redirect:/cases";
    }
}
