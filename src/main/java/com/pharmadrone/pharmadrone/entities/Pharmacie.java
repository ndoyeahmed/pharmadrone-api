package com.pharmadrone.pharmadrone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Pharmacie {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String telephone;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "id")
    private Region region;
}
