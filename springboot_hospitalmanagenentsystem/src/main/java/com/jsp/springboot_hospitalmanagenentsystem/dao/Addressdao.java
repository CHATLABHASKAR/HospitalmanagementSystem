package com.jsp.springboot_hospitalmanagenentsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Address;
import com.jsp.springboot_hospitalmanagenentsystem.repo.Addressrepo;

@Repository
public class Addressdao {
	
	@Autowired
	private Addressrepo addressrepo;
	
	public Address saveAddress(Address address) {
		return addressrepo.save(address);
	}
	public Address updateAddress(int aid, Address address) {
		if(addressrepo.findById(aid).isPresent()) {
			address.setId(aid);
			return addressrepo.save(address);
			
		}else {
			return null;
		}
	}
	public Address deleteAddress(int aid) {
		if(addressrepo.findById(aid).isPresent()){
			Address address=addressrepo.findById(aid).get();
			addressrepo.deleteById(aid);
			return address;
			
		}else {
			return null;
		}
		
	}
	public Address getaddressbyid(int aid) {
		if(addressrepo.findById(aid).isPresent()) {
			return addressrepo.findById(aid).get();
			
		}else {
			return null;
		}
	}
	public List<Address> getalladdress(){
		return addressrepo.findAll();
	}

}
