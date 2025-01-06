package com.proiect.pibd.domain.cases;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Cases")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("CaseID")
    @Column(name = "CaseID")
    private int caseID;

    @Column(nullable = true, name = "AdvocateID")
    @JsonProperty("AdvocateID")
    private Integer advocateID;

    @Column(nullable = false, length = 100, name = "CaseName")
    @JsonProperty("CaseName")
    private String caseName;

    @Column(length = 50, name = "CaseType")
    @JsonProperty("CaseType")
    private String caseType;

    @Column(name = "DateOpened")
    @JsonProperty("DateOpened")
    private Date dateOpened;

    @Column(length = 50, name = "Status")
    @JsonProperty("Status")
    private String status;

    public int getCaseID() {
        return caseID;
    }

    public int getAdvocateID() {
        return advocateID;
    }

    public String getAdvocateIDAsString() {
        return advocateID != null ? advocateID.toString() : "None";
    }

    public void setAdvocateID(int advocateID) {
        this.advocateID = advocateID;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}