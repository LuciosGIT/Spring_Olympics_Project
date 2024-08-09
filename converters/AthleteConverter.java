package com.example.olympics.com.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.olympics.com.domain.Athlete;
import com.example.olympics.com.dtos.AthleteDTO;

public class AthleteConverter {

	
	static ModelMapper mapper = new ModelMapper();
	
	
	public static AthleteDTO convertAthleteToAthleteDTO(Athlete athlete) {
		AthleteDTO athleteDto = mapper.map(athlete, AthleteDTO.class);
		return athleteDto;
	}
	
	public static List<AthleteDTO> convertListOfAthleteToListOfAthleteDTO(List<Athlete> athletes){
		List<AthleteDTO> athletesDtos = new ArrayList<>();
		for(Athlete athlete : athletes) {
			athletesDtos.add(mapper.map(athlete, AthleteDTO.class));
		}
		return athletesDtos;
	}
	
	public static Athlete convertAthleteDTOToAthlete(AthleteDTO athleteDto) {
		Athlete athlete = mapper.map(athleteDto, Athlete.class);
		return athlete;
	}
}
