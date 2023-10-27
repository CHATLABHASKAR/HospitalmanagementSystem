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

import com.jsp.springboot_hospitalmanagenentsystem.dto.Encounted;
import com.jsp.springboot_hospitalmanagenentsystem.service.Encounterdservice;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class Encountercontroller {
	
	@Autowired
	private Encounterdservice encounterservice;
	
	@ApiOperation(value = "save encounter",notes = "Api is used to save the encounter")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Encounted>> saveEncounter(@Valid @RequestBody Encounted encounted, @RequestParam int pid, @RequestParam int bid) {
		return encounterservice.saveEncounter(encounted, pid, bid);
	}
	 
	@ApiOperation(value = "Update encounter",notes = "Api is used to update the encounter")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updtaed"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<Responsestructure<Encounted>> updateEncounter(@Valid @RequestBody Encounted encounted, @RequestParam int eid, @RequestParam int bid) {
		return encounterservice.updateEncounter(eid, encounted, bid);
	}
	
	@ApiOperation(value = "Delete encounter",notes = "Api is used to delete the encounter")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Encounted>> deleteEncounter(@Valid @RequestParam int eid) {
		
		return encounterservice.deletEncounter(eid);
	}
	
	@ApiOperation(value = "Get encounter By Id",notes = "Api is used to find the encounter based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Encounted>> getEncounterbyid(@Valid @RequestParam int eid) {
		return encounterservice.getEncounterbyid(eid);
	}
	

}
