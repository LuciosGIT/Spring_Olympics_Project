package com.example.olympics.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.olympics.com.domain.Athlete;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long>{

}
