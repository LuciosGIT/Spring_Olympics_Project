package com.example.olympics.com.dtos;


import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;





public class OlympicsDTO extends RepresentationModel<OlympicsDTO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
		private Long id;
		private String hostCity;
		private Integer year;
		private String countryWithMostMedals;
		
		public OlympicsDTO() {
			
		}

		public OlympicsDTO(Long id, String hostCity, Integer year, String countryWithMostMedals) {
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
			OlympicsDTO other = (OlympicsDTO) obj;
			return Objects.equals(id, other.id);
		}
	}


