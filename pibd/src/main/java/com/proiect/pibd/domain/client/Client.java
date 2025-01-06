package com.proiect.pibd.domain.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("ClientID")
    @Column(name = "ClientID")
    private int clientID;

    @Column(nullable = false, length = 50, name = "FirstName")
    @JsonProperty("FirstName")
    private String firstName;

    @Column(nullable = false, length = 50, name = "LastName")
    @JsonProperty("LastName")
    private String lastName;

    @Column(length = 200, name = "Address")
    @JsonProperty("Address")
    private String address;

    @Column(length = 20, name = "PhoneNumber")
    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @Column(length = 100, name = "Email")
    @JsonProperty("Email")
    private String email;


    public int getClientID() {
        return clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}