package com.proiect.pibd.service;

import com.proiect.pibd.domain.cases.Case;
import com.proiect.pibd.domain.cases.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    public void deleteCaseById(int id){
        caseRepository.deleteById(id);
    }

    public void saveCase(Case newCase) {
        caseRepository.save(newCase);
    }

}
