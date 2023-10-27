package com.jsp.springboot_hospitalmanagenentsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagenentsystem.dao.Meditemdao;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Meditems;
import com.jsp.springboot_hospitalmanagenentsystem.exception.IdNotFoundException;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

@Service
public class Meditemsservice {
	
	@Autowired
	private Meditemdao meditemsdao;
	
	public ResponseEntity<Responsestructure< Meditems>> saveMeditems(Meditems meditems, int  mid) {
		Responsestructure<Meditems> responsestructure=new Responsestructure<>();
		responsestructure.setMessage("sucessfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(meditemsdao.saveMeditems(meditems, mid));
		
		return new ResponseEntity<Responsestructure<Meditems>>(responsestructure, HttpStatus.CREATED);
		
	}
	public  ResponseEntity<Responsestructure<Meditems>> updateMeditems(int id, Meditems meditems ) {
        Meditems meditems2=meditemsdao.getMeditemsbyid(id);
        meditems.setMedorder(meditems2.getMedorder());
        Meditems dbMeditems=meditemsdao.updateMeditems(id, meditems2);
        if(dbMeditems!=null) {
        	Responsestructure<Meditems> responsestructure=new Responsestructure<>();
    		responsestructure.setMessage("sucessfully updated");
    		responsestructure.setStatus(HttpStatus.OK.value());
    		responsestructure.setData(meditemsdao.updateMeditems(id, dbMeditems));
        	return new ResponseEntity<Responsestructure<Meditems>>(responsestructure,HttpStatus.OK);
        }else {
        	throw new IdNotFoundException("id not found fot meditemd");
        }
	}
	public ResponseEntity<Responsestructure<Meditems>> deleteMeditems(int id) {
		Meditems meditems=meditemsdao.deleteMeditems(id);
		if(meditems!=null) {
	     	Responsestructure<Meditems> responsestructure=new Responsestructure<>();
	    		responsestructure.setMessage("sucessfully deleted");
	    		responsestructure.setStatus(HttpStatus.OK.value());
	    		responsestructure.setData(meditems);
	        	return new ResponseEntity<Responsestructure<Meditems>>(responsestructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found fot meditemd");
		}
	}
	public ResponseEntity<Responsestructure<Meditems>> getMeditemsbyid(int id) {
		Meditems meditems = meditemsdao.getMeditemsbyid(id);
		if(meditems!=null) {
		   Responsestructure<Meditems> responsestructure=new Responsestructure<>();
		   responsestructure.setMessage("sucessfully found");
		   responsestructure.setStatus(HttpStatus.FOUND.value());
		   responsestructure.setData(meditems);
			return new ResponseEntity<Responsestructure<Meditems>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("id not found");
		}
	}
} 
