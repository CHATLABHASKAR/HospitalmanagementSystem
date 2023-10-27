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

import com.jsp.springboot_hospitalmanagenentsystem.dto.Address;
import com.jsp.springboot_hospitalmanagenentsystem.service.Addressservice;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class Addresscontroll {
	
	@Autowired
	private Addressservice addressservice;
	
	@ApiOperation(value = "save address",notes = "Api is used to save the address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Address>> scarAddress(@Valid @RequestBody  Address address) {
		return addressservice.saveAddress(address);
		
	}
	@ApiOperation(value = "Update address",notes = "Api is used to update the address")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updtaed"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<Responsestructure<Address>> updateAddress(@Valid @RequestParam int aid, @RequestBody Address address) {
		return addressservice.updateAddress(aid, address);
	}
	
	@ApiOperation(value = "Delete address",notes = "Api is used to delete the address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Address>> deleteAddress(@Valid @RequestParam int aid) {
		return addressservice.deleteAddress(aid);
		
	}
	
	@ApiOperation(value = "Get address By Id",notes = "Api is used to find the address based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Address>> getAddressbyid(@Valid @RequestParam int aid) {
		return addressservice.getAddressbyid(aid);
	}

}
