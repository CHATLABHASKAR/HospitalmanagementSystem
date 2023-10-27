package com.jsp.springboot_hospitalmanagenentsystem.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagenentsystem.dao.Persondao;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Person;
import com.jsp.springboot_hospitalmanagenentsystem.exception.IdNotFoundException;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

@Service
public class Personservice {
	
	@Autowired
	private Persondao persondao;
	
	public ResponseEntity<Responsestructure<Person>> savePerson(Person person) {
		Responsestructure<Person> responseStructure=new Responsestructure<>();
		responseStructure.setMessage("succesfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(persondao.saveperson(person));
		return new ResponseEntity<Responsestructure<Person>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<Responsestructure<Person>> updatePerson(int id,Person person) {
		Person dbPerson=persondao.updatePerson(id, person); 
		
		if(dbPerson!=null) {
			Responsestructure<Person> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully saved");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbPerson);
			return new ResponseEntity<Responsestructure<Person>>(responseStructure,HttpStatus.OK);
			
		}else {
			return null;
		}
		
	}
	public ResponseEntity<Responsestructure<Person>> deletePerson(int id) {
		Person person=persondao.deletPerson(id);
		if(person!=null) {
			Responsestructure<Person> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<Responsestructure<Person>>(responseStructure,HttpStatus.OK);
		
		}else {
			return null;
		}
		
	}
	public ResponseEntity<Responsestructure< Person>> getPersonbyid(int id) {
		Person person=persondao.getPersonbyid(id);
		if(person!=null) {
			Responsestructure<Person> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("succesfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<Responsestructure<Person>>(responseStructure,HttpStatus.FOUND);
		
		}else {
			return null;
		}
		
	}
	public List<Person> getallPersons() {
		return persondao.getallperson();
	}
}