package com.jsp.springboot_hospitalmanagenentsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Person;
import com.jsp.springboot_hospitalmanagenentsystem.service.Personservice;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/person")
public class Personcontroller {
	
	
	@Autowired
	private Personservice personservice;
	
	@ApiOperation(value = "save person",notes = "Api is used to save the person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure< Person>> savePerson(@Valid @RequestBody Person person) {
		return personservice.savePerson(person);
	}
	
	@ApiOperation(value = "Update person",notes = "Api is used to update the person")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updtaed"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<Responsestructure< Person>> uptatePerson(@Valid @RequestParam int pid, @RequestBody Person person) {
		return personservice.updatePerson(pid, person);
	}
 
	@ApiOperation(value = "Delete person",notes = "Api is used to delete the person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure< Person>> deletePerson(@Valid @RequestParam int pid, @RequestBody Person person) {
		return personservice.deletePerson(pid);
	}
	
	@ApiOperation(value = "Get person By Id",notes = "Api is used to find the person based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
    @GetMapping
	public ResponseEntity<Responsestructure< Person>>getPersonbyid(@Valid @RequestParam int pid) {
		return personservice.getPersonbyid(pid);
	}


}
