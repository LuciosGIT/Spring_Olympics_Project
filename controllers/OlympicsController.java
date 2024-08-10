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
import com.example.olympics.com.util.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/olympics")
public class OlympicsController {
	
	@Autowired
	private OlympicsService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all Olympics editions", description = "finds all Olympics editions",
	tags = {"Olympics"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = {@Content(
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = OlympicsDTO.class))
							)}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<List<OlympicsDTO>> findAll(){
		List<OlympicsDTO> olympics = service.findAll();
		return ResponseEntity.ok().body(olympics);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds an Olympics edition", description = "finds an Olympics edition",
	tags = {"Olympics"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = OlympicsDTO.class))
							),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<OlympicsDTO> findById(@PathVariable Long id){
		OlympicsDTO olympics = service.findById(id);
		return ResponseEntity.ok().body(olympics);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Adds a new Olympics edition", description = "adds a new Olympics edition by passing in a JSON, XML or YML representation of the Olympics!",
	tags = {"Olympics"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content),
			@ApiResponse(description = "Created", responseCode = "201",content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<Void> create(@RequestBody OlympicsDTO olympicsDto){
		service.create(olympicsDto); 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(olympicsDto.getId())
                .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/{id}",consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Updates an Olympics edition", description = "updates an Olympics edition by passing in a JSON, XML or YML representation of the Olympics!",
	tags = {"Olympics"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = @Content),
			@ApiResponse(description = "No Content", responseCode = "204",content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody OlympicsDTO olympicsDto){
		olympicsDto.setId(id);
		service.update(olympicsDto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletes an Olympic edition", description = "deletes an Olympic edition by passing their id",
	tags = {"Olympics"},
	responses = {
			@ApiResponse(description = "No Content", responseCode = "204",content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			
	})
	public ResponseEntity<Void> delete(Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
