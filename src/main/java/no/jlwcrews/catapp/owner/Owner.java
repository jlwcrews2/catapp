package no.jlwcrews.catapp.owner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import no.jlwcrews.catapp.cat.Cat;

import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(generator = "ownergen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ownergen", sequenceName = "owner_seq", allocationSize = 1)
    private Long ownerId;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerEmail;

    @OneToMany(mappedBy = "owner")
    @JsonIgnoreProperties("owner")
    private List<Cat> cats;

    public Owner(){}

    public Owner(String ownerFirstName, String ownerLastName, String ownerEmail) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.ownerEmail = ownerEmail;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
