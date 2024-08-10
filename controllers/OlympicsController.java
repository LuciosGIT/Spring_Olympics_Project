package com.example.olympics.com.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.olympics.com.dtos.OlympicsDTO;
import com.example.olympics.com.services.OlympicsService;

@RestController
@RequestMapping("/olympics")
public class OlympicsController {
	
	@Autowired
	private OlympicsService service;
	
	@GetMapping
	public ResponseEntity<List<OlympicsDTO>> findAll(){
		List<OlympicsDTO> olympics = service.findAll();
		return ResponseEntity.ok().body(olympics);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OlympicsDTO> findById(@PathVariable Long id){
		OlympicsDTO olympics = service.findById(id);
		return ResponseEntity.ok().body(olympics);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody OlympicsDTO olympicsDto){
		service.create(olympicsDto); 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(olympicsDto.getId())
                .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody OlympicsDTO olympicsDto){
		olympicsDto.setId(id);
		service.update(olympicsDto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
