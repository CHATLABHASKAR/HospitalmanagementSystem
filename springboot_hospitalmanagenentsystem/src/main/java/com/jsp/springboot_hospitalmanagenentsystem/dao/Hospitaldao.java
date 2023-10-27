package com.jsp.springboot_hospitalmanagenentsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagenentsystem.repo.Hospitalrepo;

@Repository
public class Hospitaldao {
	
	@Autowired
	private Hospitalrepo hospitalrepo;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalrepo.save(hospital);
		
	}
	public Hospital updateHospital(int id,Hospital hospital) {
		if(hospitalrepo.findById(id).isPresent()) {
			hospital.setId(id);
			return hospitalrepo.save(hospital);
		}else {
			return null;
		}
		
	}
	public Hospital deleteHospital(int id) {
		if(hospitalrepo.findById(id).isPresent()) {
			Hospital hospital=hospitalrepo.findById(id).get();
			hospitalrepo.deleteById(id);
			return hospital;
		}else {
			return null;
		}
		
	}
	public Hospital getHospitalbyid(int id) {
		Optional<Hospital> hospital=hospitalrepo.findById(id);
		if(hospital.isPresent()) {
			return hospital.get();
		}else {
			return null;
		}
		
	}
	public List<Hospital> getallHospitals() {
		return hospitalrepo.findAll();
	}
}