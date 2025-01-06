package com.proiect.pibd.domain.advocate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Advocates")
public class Advocate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("AdvocateID")
    @Column(name = "AdvocateID")
    private int advocateID;

    @Column(nullable = false, length = 50, name = "FirstName")
    @JsonProperty("FirstName")
    private String firstName;

    @Column(nullable = false, length = 50, name = "LastName")
    @JsonProperty("LastName")
    private String lastName;

    @Column(length = 100, name = "Specialty")
    @JsonProperty("Specialty")
    private String specialty;

    @Column(length = 20, name = "PhoneNumber")
    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @Column(length = 100, name = "Email")
    @JsonProperty("Email")
    private String email;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdvocateID() {
        return advocateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
