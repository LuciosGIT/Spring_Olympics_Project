package com.example.olympics.com.dtos;

import java.io.Serializable;
import java.util.Objects;

public class AthleteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
		private Long id;
		private String name;
		private Integer age;
		private String country;
		
		public AthleteDTO() {
			
		}
		

		public AthleteDTO(Long id, String name, Integer age, String country) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.country = country;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
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
			AthleteDTO other = (AthleteDTO) obj;
			return Objects.equals(id, other.id);
		}
		

	

}
