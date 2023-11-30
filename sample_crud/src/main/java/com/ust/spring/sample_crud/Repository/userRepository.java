package com.ust.spring.sample_crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.spring.sample_crud.Entity.User;

@Repository
public interface userRepository extends JpaRepository<User,Integer> {
    
}
