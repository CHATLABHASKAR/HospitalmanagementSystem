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

import com.jsp.springboot_hospitalmanagenentsystem.dto.Medorder;
import com.jsp.springboot_hospitalmanagenentsystem.service.Medorderservice;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medorder")
public class Medoredercontroller {

	@Autowired
	private Medorderservice medorederservice;

	
	@ApiOperation(value = "save medoreder",notes = "Api is used to save the medorder")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure< Medorder>> saveMedorder (@Valid @RequestBody Medorder medorder, @RequestParam int eid) {
		return medorederservice.saveMedoreder(medorder, eid);
	}
	
	@ApiOperation(value = "Update medorder",notes = "Api is used to update the medorder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updtaed"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<Responsestructure< Medorder>> updateMedorder(@Valid @RequestBody Medorder medorder, @RequestParam int mid ) {
		return medorederservice.updateMedorder(mid, medorder);
	}
	
	@ApiOperation(value = "Delete medorder",notes = "Api is used to delete the medorder")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public  ResponseEntity<Responsestructure< Medorder>> deleteMedorder(@Valid @RequestParam int mid) {
		return medorederservice.deleteMedorder(mid);
	}

	@ApiOperation(value = "Get medorder By Id",notes = "Api is used to find the medorder based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure< Medorder>> getMedorderbyid(@Valid @RequestParam int mid) {
		return medorederservice.getMedorderbyid(mid);
	}

}
