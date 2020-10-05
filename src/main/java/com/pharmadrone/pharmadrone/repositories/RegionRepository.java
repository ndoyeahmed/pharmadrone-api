package com.pharmadrone.pharmadrone.repositories;

import com.pharmadrone.pharmadrone.entities.Region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    
}