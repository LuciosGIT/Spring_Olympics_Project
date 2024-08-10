package com.example.olympics.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.olympics.com.domain.Olympics;

public interface OlympicsRepository extends JpaRepository<Olympics,Long>{

}
