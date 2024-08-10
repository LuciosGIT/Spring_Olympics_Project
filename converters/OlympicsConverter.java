package com.example.olympics.com.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.olympics.com.domain.Olympics;
import com.example.olympics.com.dtos.OlympicsDTO;

public class OlympicsConverter {

	
	static ModelMapper mapper = new ModelMapper();
	
	
	public static OlympicsDTO convertOlympicsToOlympicsDTO(Olympics Olympics) {
		OlympicsDTO olympicsDto = mapper.map(Olympics, OlympicsDTO.class);
		return olympicsDto;
	}
	
	public static Olympics convertOlympicsDtoToOlympics(OlympicsDTO OlympicsDto) {
		Olympics olympics = mapper.map(OlympicsDto, Olympics.class);
		return olympics;
	}
	
	public static List<OlympicsDTO> convertListOfOlympicsToListOfOlympicsDto(List<Olympics> Olympics){
		List<OlympicsDTO> olympicsDtos = new ArrayList<>();
		for(Olympics olympics : Olympics) {
			olympicsDtos.add(mapper.map(olympics, OlympicsDTO.class));
			
		}
		return olympicsDtos;
	}
	
}
