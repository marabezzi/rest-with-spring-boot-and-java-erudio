package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//@CrossOrigin
@RestController
@RequestMapping("api/person/v1")
@Tag(name =  "People", description = "Endpoints for Managing People")
public class PersonController {

	@Autowired
	private PersonServices service;
	
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	@Operation(summary = "Finds all People", description = "Finds all People",
	tags = {"People"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", 
					content = { 
				    	@Content(
				    			mediaType = "application/json",
				    			array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
				    	)
				    }),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	 }
    )
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	@Operation(summary = "Finds a Person", description = "Finds a Person",
	tags = {"People"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = PersonVO.class))
				        ),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	 }
    )
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@CrossOrigin(origins = {"http://localhost:8081", "https://erudio.com.br"})
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	@Operation(summary = "Adds a new Person", description = "Adds a new Person by passing a JSON, XML or YML representation of",
	tags = {"People"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = PersonVO.class))
				        ),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	 }
    )
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);	
    }
	
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	@Operation(summary = "Updates a Person", description = "Updates a new Person by passing a JSON, XML or YML representation of",
	tags = {"People"},
	responses = {
		@ApiResponse(description = "Updated", responseCode = "200", 
				content = @Content(schema = @Schema(implementation = PersonVO.class))
			        ),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
	)
	public PersonVO update(@RequestBody PersonVO person) {
		return service.update(person);	
    }
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletes a Person", description = "Deletes new Person by passing a JSON, XML or YML representation of",
	tags = {"People"},
	responses = {
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
	)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);	
		return ResponseEntity.noContent().build();
    }
	
}
	