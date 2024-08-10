package com.example.olympics.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.olympics.com.domain.Athlete;


public interface AthleteRepository extends JpaRepository<Athlete, Long>{

}
