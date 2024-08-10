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

import com.example.olympics.com.dtos.AthleteDTO;
import com.example.olympics.com.services.AthleteService;
import com.example.olympics.com.util.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/athletes")
public class AthleteController {

	@Autowired
	AthleteService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all athletes", description = "finds all athletes",
	tags = {"Athlete"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = {@Content(
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = AthleteDTO.class))
							)}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<List<AthleteDTO>> findAll(){
		List<AthleteDTO> athletes = service.findAll();
		return ResponseEntity.ok().body(athletes);
	}
	
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds an athlete", description = "finds an athlete",
	tags = {"Athlete"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = AthleteDTO.class))
							),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<AthleteDTO> findById(@PathVariable Long id){
		AthleteDTO athlete = service.findById(id);
		return ResponseEntity.ok().body(athlete);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Adds a new athlete", description = "adds a new athlete by passing in a JSON, XML or YML representation of the athlete!",
	tags = {"Athlete"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content),
			@ApiResponse(description = "Created", responseCode = "201",content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<Void> create(@RequestBody AthleteDTO athlete){
		service.create(athlete); 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(athlete.getId())
                .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/{id}",consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Updates an athlete", description = "updates an athlete by passing in a JSON, XML or YML representation of the athlete!",
	tags = {"Athlete"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = @Content),
			@ApiResponse(description = "No Content", responseCode = "204",content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody AthleteDTO athlete){
		athlete.setId(id);
		service.update(athlete);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletes an user", description = "deletes an user by passing their id",
	tags = {"Athlete"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204",content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
