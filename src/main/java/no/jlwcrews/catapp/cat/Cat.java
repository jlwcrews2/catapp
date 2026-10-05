package no.jlwcrews.catapp.cat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import no.jlwcrews.catapp.owner.Owner;

@Entity
public class Cat{

    @Id
    @GeneratedValue(generator = "catgen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "catgen", initialValue = 1, allocationSize = 1, sequenceName = "cat_seq")
    private Long catId;
    private String catName;
    private String catColor;
    private int catAge;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnoreProperties("cats")
    private Owner owner;

    public Cat() {
    }

    public Cat(String catName, String catColor, int catAge) {
        this.catName = catName;
        this.catColor = catColor;
        this.catAge = catAge;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long id) {
        this.catId = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String name) {
        this.catName = name;
    }

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String color) {
        this.catColor = color;
    }

    public int getCatAge() {
        return catAge;
    }

    public void setCatAge(int age) {
        this.catAge = age;
    }
}


