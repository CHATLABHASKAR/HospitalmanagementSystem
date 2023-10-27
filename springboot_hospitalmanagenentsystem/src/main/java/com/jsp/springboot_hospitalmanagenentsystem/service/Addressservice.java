package com.jsp.springboot_hospitalmanagenentsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagenentsystem.dao.Addressdao;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Address;
import com.jsp.springboot_hospitalmanagenentsystem.exception.IdNotFoundException;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;


@Service
public class Addressservice {
	
	@Autowired
	private Addressdao addressdao;
	
	public ResponseEntity<Responsestructure< Address>> saveAddress(Address address) {
		Responsestructure<Address> responseStructure=new Responsestructure<>();
		responseStructure.setMessage("succesfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressdao.saveAddress(address));
		return new ResponseEntity<Responsestructure<Address>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<Responsestructure< Address>> updateAddress(int aid,Address address) {
		Address dbAddress=addressdao.updateAddress(aid, address);
		if(dbAddress!=null) {
			Responsestructure<Address> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbAddress);
			return new ResponseEntity<Responsestructure<Address>>(responseStructure,HttpStatus.OK);
		}else{
			throw new  IdNotFoundException("id not found");
			
		}
		
	}
	public ResponseEntity<Responsestructure< Address>> deleteAddress(int aid) {
		Address address=addressdao.deleteAddress(aid);
		if(address!=null) {
			Responsestructure<Address> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<Responsestructure<Address>>(responseStructure,HttpStatus.OK);

		}else {
			throw new  IdNotFoundException("id not found");
		}
		
	}
	public ResponseEntity<Responsestructure< Address>> getAddressbyid(int aid) {
		Address address=addressdao.getaddressbyid(aid);
		if(address!=null) {
			Responsestructure<Address> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<Responsestructure<Address>>(responseStructure,HttpStatus.FOUND);
		}else {
		      throw new NoSuchElementException("id not found");
		}
		
	}
}
