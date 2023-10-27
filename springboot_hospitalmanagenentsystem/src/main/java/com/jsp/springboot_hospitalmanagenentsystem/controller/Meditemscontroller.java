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

import com.jsp.springboot_hospitalmanagenentsystem.dto.Meditems;
import com.jsp.springboot_hospitalmanagenentsystem.service.Meditemsservice;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/meditems")
public class Meditemscontroller {

	@Autowired
	private Meditemsservice meditemsservice;

	
	@ApiOperation(value = "save meditems",notes = "Api is used to save the meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Meditems>> saveMeditems(@Valid @RequestParam int id, @RequestBody Meditems meditems) {
		return meditemsservice.saveMeditems(meditems, id);
	}

	
	@ApiOperation(value = "Update meditems",notes = "Api is used to update the meditems")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updtaed"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<Responsestructure<Meditems>> updateMeditems(@Valid @RequestBody Meditems meditems, @RequestParam int id) {
		return meditemsservice.updateMeditems(id, meditems);
	}
	
	
	@ApiOperation(value = "Delete meditems",notes = "Api is used to delete the meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Meditems>> deleteMeditems(@Valid @RequestParam int id) {
		return  meditemsservice.deleteMeditems(id);
	}
	
	@ApiOperation(value = "Get meditems By Id",notes = "Api is used to find the meditems based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Meditems>> getMeditemsbyid(@Valid @RequestParam int id) {
		return meditemsservice.getMeditemsbyid(id);
	}


}
