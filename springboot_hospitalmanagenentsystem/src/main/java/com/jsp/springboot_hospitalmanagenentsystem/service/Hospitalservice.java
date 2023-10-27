package com.jsp.springboot_hospitalmanagenentsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.springboot_hospitalmanagenentsystem.dao.Hospitaldao;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagenentsystem.exception.IdNotFoundException;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

@Service
public class Hospitalservice {
	
	@Autowired
	private Hospitaldao hospitaldao;
	
	public ResponseEntity<Responsestructure<Hospital>> saveHospital(Hospital hospital) {
		Responsestructure<Hospital> responseStructure=new Responsestructure<>();
		responseStructure.setMessage("succesfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hospitaldao.saveHospital(hospital));
		return new ResponseEntity<Responsestructure<Hospital>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<Responsestructure<Hospital>> updateHospital(int id,Hospital hospital) {
		Hospital dbHospital=hospitaldao.updateHospital(id, hospital);
		if(dbHospital!=null) {
			Responsestructure<Hospital> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbHospital);
			return new  ResponseEntity<Responsestructure<Hospital>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for hospital");
		}
		
	}
	public ResponseEntity<Responsestructure<Hospital>> deleteHospital(int id) {
		Hospital hospital=hospitaldao.deleteHospital(id);
		if(hospital!=null) {
			Responsestructure<Hospital> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<Responsestructure<Hospital>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found");
		}
		
	}
	public ResponseEntity<Responsestructure<Hospital>> getHospitalbyid(int id) {
		Hospital hospital=hospitaldao.getHospitalbyid(id);
		if(hospital!=null) {
			Responsestructure<Hospital> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<Responsestructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
		
	}
}
