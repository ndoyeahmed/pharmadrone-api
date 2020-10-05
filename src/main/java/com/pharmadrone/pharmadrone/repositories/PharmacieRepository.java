package com.pharmadrone.pharmadrone.repositories;

import java.util.Optional;

import com.pharmadrone.pharmadrone.entities.Pharmacie;
import com.pharmadrone.pharmadrone.entities.Region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {
    Optional<Pharmacie> findByTelephone(String telephone);

    Optional<Pharmacie> findByNom(String nom);

    Optional<Pharmacie> findByRegion(Region region);
}
