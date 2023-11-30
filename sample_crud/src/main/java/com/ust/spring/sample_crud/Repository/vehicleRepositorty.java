package com.ust.spring.sample_crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.spring.sample_crud.Entity.Vehicle;

@Repository
public interface vehicleRepositorty extends JpaRepository<Vehicle,Integer> {
    
}
