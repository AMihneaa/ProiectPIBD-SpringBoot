package com.proiect.pibd.domain.advocate_client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "Advocate_Client")
public class AdvocateClient {
    @EmbeddedId
    private AdvocateClientId id;

    @Column(nullable = false)
    private Date dateAssigned;

    @Embeddable
    @Data
    public static class AdvocateClientId {
        @JsonProperty("AdvocateID")
        @Column(name = "AdvocateID")
        private int advocateID;

        @JsonProperty("ClientID")
        @Column(name = "ClientID")
        private int clientID;

        public AdvocateClientId(int advocateID, int clientID) {
            this.advocateID = advocateID;
            this.clientID = clientID;
        }

        public AdvocateClientId() {
        }

        public void setAdvocateID(int advocateID) {
            this.advocateID = advocateID;
        }

        public void setClientID(int clientID) {
            this.clientID = clientID;
        }
    }

    public AdvocateClient(int advocateID, int clientID, Date dateAssigned) {
        AdvocateClientId id = new AdvocateClientId();
        id.setAdvocateID(advocateID);
        id.setClientID(clientID);
        this.id = id;
        this.dateAssigned = dateAssigned;
    }

    public AdvocateClient() {
    }

    public AdvocateClientId getId() {
        return id;
    }

    public void setId(AdvocateClientId id) {
        this.id = id;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }
}