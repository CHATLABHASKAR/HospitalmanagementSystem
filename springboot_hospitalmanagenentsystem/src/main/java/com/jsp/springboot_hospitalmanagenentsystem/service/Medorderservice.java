package com.jsp.springboot_hospitalmanagenentsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagenentsystem.dao.Medorderdao;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Medorder;
import com.jsp.springboot_hospitalmanagenentsystem.exception.IdNotFoundException;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;
@Service
public class Medorderservice {
	@Autowired
	private Medorderdao medorderdao;
	
	public ResponseEntity<Responsestructure< Medorder>> saveMedoreder(Medorder medorder, int eid) {
		Responsestructure<Medorder> responsestructure=new Responsestructure<>();
		responsestructure.setMessage("sucessfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(medorderdao.saveMedorder(medorder, eid));
		return new ResponseEntity<Responsestructure<Medorder>>(responsestructure, HttpStatus.CREATED);
	}
	public ResponseEntity<Responsestructure<Medorder>> updateMedorder(int mid, Medorder medorder) {
		Medorder medorder2=medorderdao.getMedorderbyid(mid);
		medorder.setEncounter(medorder2.getEncounter());
		Medorder dbMedorder=medorderdao.updateMedorder(mid, medorder2);
		if(dbMedorder!=null) {
			
			Responsestructure< Medorder> responsestructure=new Responsestructure<>();
			responsestructure.setMessage("sucessfully updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(dbMedorder);
			
			
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure,HttpStatus.OK);
			
		}else {
				throw new IdNotFoundException("id not found for Medorder");
			}
	}
	public ResponseEntity<Responsestructure<Medorder>>  deleteMedorder(int mid) {
		Medorder medorder = medorderdao.deleteMedorderbyid(mid);
		if(medorder!=null) {
			Responsestructure< Medorder> responsestructure=new Responsestructure<>();
			responsestructure.setMessage("sucessfully deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(medorder);
			
			
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("id not found for Medorder");
		}
	}
	public ResponseEntity<Responsestructure< Medorder>> getMedorderbyid(int mid) {
		Medorder medorder=medorderdao.getMedorderbyid(mid);
		if(medorder!=null) {
			Responsestructure< Medorder> responsestructure= new Responsestructure<>();
			responsestructure.setMessage("sucessfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(medorder);
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("id not found");
		}
	}

}
