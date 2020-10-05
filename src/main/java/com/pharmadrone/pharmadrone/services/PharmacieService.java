package com.pharmadrone.pharmadrone.services;

import java.util.List;

import com.pharmadrone.pharmadrone.entities.Pharmacie;
import com.pharmadrone.pharmadrone.entities.Region;
import com.pharmadrone.pharmadrone.repositories.PharmacieRepository;
import com.pharmadrone.pharmadrone.repositories.RegionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class PharmacieService {

    private PharmacieRepository pharmacieRepository;
    private RegionRepository regionRepository;

    @Autowired
    public PharmacieService(PharmacieRepository pharmacieRepository, RegionRepository regionRepository) {
        this.pharmacieRepository = pharmacieRepository;
        this.regionRepository = regionRepository;
    }

    /**
     * add a new pharmacy into database
     * 
     * @param pharmacie
     * @return the added item or throw an exception
     */
    public Pharmacie addPharmacie(Pharmacie pharmacie) {
        try {
            pharmacieRepository.save(pharmacie);
            return pharmacie;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    /**
     * get a pharmacy from database by ID
     * @param id
     * @return pharmacy if found or return null
     */
    public Pharmacie getPharmacieById(Long id) {
        return pharmacieRepository.findById(id).orElse(null);
    }

    /**
     * get a pharmacy from database by telephone
     * @param telephone
     * @return pharmacy if found or return null
     */
    public Pharmacie getPharmacieByTelephone(String telephone) {
        return pharmacieRepository.findByTelephone(telephone).orElse(null);
    }

    /**
     * get a pharmacy from database by region
     * @param region
     * @return pharmacy if found or return null
     */
    public Pharmacie getPharmacieByRegion(Region region) {
        return pharmacieRepository.findByRegion(region).orElse(null);
    }

    /**
     * get a pharmacy from database by nom
     * @param nom
     * @return pharmacy if found or return null
     */
    public Pharmacie getPharmacieByNom(String nom) {
        return pharmacieRepository.findByNom(nom).orElse(null);
    }

    /**
     * get a region from database by ID
     * @param id
     * @return region if found or return null
     */
    public Region getRegionById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    /**
     * get list of pharmacy from database
     * 
     * @return a list of pharmacy
     */
    public List<Pharmacie> getAllPharmacies() {
        return pharmacieRepository.findAll();
    }

    /**
     * get list of region from database
     * @return a list of region
     */
    public List<Region> getListRegion() {
        return regionRepository.findAll();
    }

}
