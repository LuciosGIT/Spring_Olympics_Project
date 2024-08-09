package com.example.olympics.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.olympics.com.converters.AthleteConverter;
import com.example.olympics.com.dtos.AthleteDTO;
import com.example.olympics.com.exceptions.ObjectNotFoundException;
import com.example.olympics.com.repositories.AthleteRepository;

@Service
public class AthleteService {
	
	@Autowired
	private AthleteRepository repository;
	
	public List<AthleteDTO> findAll(){
		List<AthleteDTO> athletes = AthleteConverter
				.convertListOfAthleteToListOfAthleteDTO(repository.findAll());
		return athletes;
	}
	
	public AthleteDTO findById(Long id) {
		AthleteDTO athlete = AthleteConverter
				.convertAthleteToAthleteDTO(repository.findById(id)
						.orElseThrow(() -> new ObjectNotFoundException("Object not found!")));
	return athlete;
	}
	
	public void create(AthleteDTO athlete) {
		repository.save(AthleteConverter.convertAthleteDTOToAthlete(athlete));
		
	}
	
	public void update(AthleteDTO obj) {
		AthleteDTO athlete = findById(obj.getId());
		athlete.setAge(obj.getAge());
		athlete.setCountry(obj.getCountry());
		athlete.setName(obj.getName());
		repository.save(AthleteConverter.convertAthleteDTOToAthlete(athlete));
		
	}
	
	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	
}
