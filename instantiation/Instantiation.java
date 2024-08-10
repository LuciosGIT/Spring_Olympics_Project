package com.example.olympics.com.instantiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.olympics.com.converters.AthleteConverter;
import com.example.olympics.com.converters.OlympicsConverter;
import com.example.olympics.com.domain.Athlete;
import com.example.olympics.com.domain.Olympics;
import com.example.olympics.com.dtos.AthleteDTO;
import com.example.olympics.com.dtos.OlympicsDTO;
import com.example.olympics.com.repositories.AthleteRepository;
import com.example.olympics.com.repositories.OlympicsRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	AthleteRepository athlRepository;
	
	@Autowired
	OlympicsRepository olymRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
	    
	
	    AthleteDTO athlete1Dto = new AthleteDTO(null, "Serginho Escadinha", 48, "Brazil");
	    AthleteDTO athlete2Dto = new AthleteDTO(null, "Ana Barbosu", 18, "Romania");
	    
	    OlympicsDTO olympic1Dto = new OlympicsDTO(null, "Paris", 2024, "United States");
	    OlympicsDTO olympic2Dto = new OlympicsDTO(null, "Rio", 2016, "United States");
	    

	    Athlete athlete1 = AthleteConverter.convertAthleteDTOToAthlete(athlete1Dto);
	    Athlete athlete2 = AthleteConverter.convertAthleteDTOToAthlete(athlete2Dto);
	    
	    Olympics olympic1 = OlympicsConverter.convertOlympicsDtoToOlympics(olympic1Dto);
	    Olympics olympic2 = OlympicsConverter.convertOlympicsDtoToOlympics(olympic2Dto);
	    

	    olympic1 = olymRepository.save(olympic1);
	    olympic2 = olymRepository.save(olympic2);
	    
	   
	    athlete1.getOlympics().add(olympic1);
	    athlete1.getOlympics().add(olympic2);
	    
	    athlete2.getOlympics().add(olympic1);
	    
	   
	    athlete1 = athlRepository.save(athlete1);
	    athlete2 = athlRepository.save(athlete2);
	    
	  
	    olympic1.getAthletes().add(athlete1);
	    olympic1.getAthletes().add(athlete2);
	    
	    olympic2.getAthletes().add(athlete1);
	    
	   
	    olymRepository.save(olympic1);
	    olymRepository.save(olympic2);
	    
	   
	  
	}
}
