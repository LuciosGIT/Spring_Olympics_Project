package com.example.olympics.com.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;


@Entity
public class Olympics implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hostCity;
	private Integer year;
	private String countryWithMostMedals;
	
	public List<Athlete> getAthletes() {
		return athletes;
	}


	@ManyToMany
	@JoinTable(
			name = "athlete_olympics",
			joinColumns = @JoinColumn(name = "olympics_id"),
			inverseJoinColumns = @JoinColumn(name = "athlete_id"))
	private List<Athlete> athletes = new ArrayList<>();
	
	public Olympics() {
		
	}

	public Olympics(Long id, String hostCity, Integer year, String countryWithMostMedals) {
		super();
		this.id = id;
		this.hostCity = hostCity;
		this.year = year;
		this.countryWithMostMedals = countryWithMostMedals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHostCity() {
		return hostCity;
	}

	public void setHostCity(String hostCity) {
		this.hostCity = hostCity;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getCountryWithMostMedals() {
		return countryWithMostMedals;
	}

	public void setCountryWithMostMedals(String countryWithMostMedals) {
		this.countryWithMostMedals = countryWithMostMedals;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Olympics other = (Olympics) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
