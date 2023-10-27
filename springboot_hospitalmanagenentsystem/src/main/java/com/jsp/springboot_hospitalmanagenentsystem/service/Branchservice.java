package com.jsp.springboot_hospitalmanagenentsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagenentsystem.dao.Branchdao;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagenentsystem.exception.IdNotFoundException;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

@Service
public class Branchservice {
	@Autowired
	private Branchdao branchdao;
	
	public ResponseEntity<Responsestructure< Branch>> saveBranch(int hid,int aid,Branch branch) {
		Responsestructure<Branch> responseStructure=new Responsestructure<>();
		responseStructure.setMessage("succesfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchdao.saveBranch(branch, hid, aid));
		return new ResponseEntity<Responsestructure<Branch>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<Responsestructure< Branch>> updateBranch(int bid,Branch branch) {
		Branch dbBranch=branchdao.updateBranch(bid, branch);
		if(dbBranch!=null) {
			Responsestructure<Branch> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbBranch);
			return new ResponseEntity<Responsestructure<Branch>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found");
		}
		
	}
	public ResponseEntity<Responsestructure< Branch>> deleteBranch(int bid) {
		Branch branch=branchdao.deleteBranch(bid);
		if(branch!=null) {
			Responsestructure<Branch> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully deteted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<Responsestructure<Branch>>(responseStructure,HttpStatus.OK);
	
		}else {
			throw new IdNotFoundException("id not found");
		}
		
	}
	public ResponseEntity<Responsestructure< Branch>> getBranchbyid(int bid) {
		Branch branch=branchdao.getBranchbyid(bid);
		if(branch!=null) {
			Responsestructure<Branch> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<Responsestructure<Branch>>(responseStructure,HttpStatus.FOUND);
	
		}else {
		     throw new NoSuchElementException("id not found");
		}
		
	}
}