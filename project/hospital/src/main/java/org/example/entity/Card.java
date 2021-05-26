package org.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "disease", nullable = true, length = 45)
    private String disease;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity=Patient.class, mappedBy = "card", cascade = {CascadeType.ALL})
    private Collection<Patient> patients;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }
}
