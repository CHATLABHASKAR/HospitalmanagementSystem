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

import com.jsp.springboot_hospitalmanagenentsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagenentsystem.service.Hospitalservice;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class Hospitalcontroller {

	@Autowired
	private Hospitalservice hospitalservice;
	
	@ApiOperation(value = "save hospital",notes = "Api is used to save the hospital")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return hospitalservice.saveHospital(hospital);
		
	}
	
	@ApiOperation(value = "Update hospital",notes = "Api is used to update the hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updtaed"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<Responsestructure<Hospital>> updateHospital(@Valid @RequestParam int id,@RequestBody Hospital hospital) {
		return hospitalservice.updateHospital(id, hospital);
	}
	
	@ApiOperation(value = "Delete hospital",notes = "Api is used to delete the hospital")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Hospital>> deleteHospital(@Valid @RequestParam int id) {
		return hospitalservice.deleteHospital(id);
	}
	
	@ApiOperation(value = "Get hospital By Id",notes = "Api is used to find the hospital based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Hospital>> getHospitalbyid(@Valid @RequestParam int id) {
		return hospitalservice.getHospitalbyid(id);
	}
}