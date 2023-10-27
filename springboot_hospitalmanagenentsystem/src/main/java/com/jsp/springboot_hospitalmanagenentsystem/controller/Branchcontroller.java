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

import com.jsp.springboot_hospitalmanagenentsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagenentsystem.service.Branchservice;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/branch")
public class Branchcontroller {
	
	
	@Autowired
	private Branchservice branchservice;
	
	
	@ApiOperation(value = "save branch",notes = "Api is used to save the branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure< Branch>> saveBranch( @Valid @RequestBody Branch branch, @RequestParam int hid, @RequestParam int aid) {
		return branchservice.saveBranch(hid, aid, branch);
	}
	
	
	@ApiOperation(value = "Update branch",notes = "Api is used to update the brach")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully updtaed"),
			@ApiResponse(code = 404,message = "id not found")})
	@PutMapping
	public ResponseEntity<Responsestructure< Branch>> updateBranch(@Valid @RequestBody Branch branch, @RequestParam int bid) {
		return branchservice.updateBranch(bid, branch);
	}
	
	
	@ApiOperation(value = "Delete brach",notes = "Api is used to delete the branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),
			@ApiResponse(code = 404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure< Branch>>deleteBranch (@Valid @RequestParam int bid) {
		return branchservice.deleteBranch(bid);
	}
	
	@ApiOperation(value = "Get branch By Id",notes = "Api is used to find the branch based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),
			@ApiResponse(code = 404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure< Branch>> getBranchbyid (@Valid @RequestParam int bid) {
		return branchservice.getBranchbyid(bid);
	}
	
	

}
