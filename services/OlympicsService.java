package com.example.olympics.com.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.olympics.com.controllers.OlympicsController;
import com.example.olympics.com.converters.OlympicsConverter;
import com.example.olympics.com.dtos.OlympicsDTO;
import com.example.olympics.com.exceptions.ObjectNotFoundException;
import com.example.olympics.com.repositories.OlympicsRepository;

@Service
public class OlympicsService {
	
	@Autowired
	OlympicsRepository repository;
	
	public List<OlympicsDTO> findAll(){
		List<OlympicsDTO> olympicsDtos = OlympicsConverter.convertListOfOlympicsToListOfOlympicsDto(repository.findAll());
		olympicsDtos.stream().forEach(p -> p.add(linkTo(methodOn(OlympicsController.class).findById(p.getId())).withSelfRel()));
		return olympicsDtos;
	}
	
	public OlympicsDTO findById(Long id) {
		OlympicsDTO olympicDto = OlympicsConverter.convertOlympicsToOlympicsDTO(repository
				.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found!")));
		olympicDto.add(linkTo(methodOn(OlympicsController.class).findById(id)).withSelfRel());
		return olympicDto;
	}
	
	public void create(OlympicsDTO olympicsDto) {
		repository.save(OlympicsConverter.convertOlympicsDtoToOlympics(olympicsDto));
	}
	
	public void update(OlympicsDTO olympicsDto) {
		OlympicsDTO olympics = findById(olympicsDto.getId());
		olympics.setCountryWithMostMedals(olympicsDto.getCountryWithMostMedals());
		olympics.setHostCity(olympicsDto.getHostCity());
		olympics.setYear(olympicsDto.getYear());
		repository.save(OlympicsConverter.convertOlympicsDtoToOlympics(olympics));
		
	}
	
	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
}
