package com.jsp.springboot_hospitalmanagenentsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagenentsystem.dao.Branchdao;
import com.jsp.springboot_hospitalmanagenentsystem.dao.Encounterdao;
import com.jsp.springboot_hospitalmanagenentsystem.dao.Persondao;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Encounted;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Person;
import com.jsp.springboot_hospitalmanagenentsystem.exception.IdNotFoundException;
import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

@Service
public class Encounterdservice {
	
	@Autowired
	private Encounterdao encounterdao;
	
	@Autowired
	private Persondao persondao;
	
	@Autowired
	private Branchdao branchdao;
	
	public ResponseEntity<Responsestructure<Encounted>> saveEncounter(Encounted encounter,int pid,int bid) {
		Person person=persondao.getPersonbyid(pid);
		Branch branch=branchdao.getBranchbyid(bid);
		
		encounter.setPerson(person);
		List<Branch> list=new ArrayList<>();
		list.add(branch);
		encounter.setBranchs(list);
		
		Responsestructure<Encounted> responseStructure=new Responsestructure<>();
		responseStructure.setMessage("succesfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterdao.saveEncounted(encounter));
		
		return new ResponseEntity<Responsestructure<Encounted>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<Responsestructure<Encounted>> updateEncounter(int eid,Encounted encounted,int bid) {
		Encounted dbEncounter=encounterdao.getEncountedbyid(eid);
		Branch branch=branchdao.getBranchbyid(bid);
		
		List<Branch> list=dbEncounter.getBranchs();
		encounted.setBranchs(dbEncounter.getBranchs());
		encounted.setPerson(dbEncounter.getPerson());
		
		Responsestructure<Encounted> responseStructure=new Responsestructure<>();
		responseStructure.setMessage("updated succesfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterdao.updatEncounted(eid, dbEncounter));
		
		return new ResponseEntity<Responsestructure<Encounted>>(responseStructure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<Responsestructure<Encounted>> deletEncounter(int eid) {
		Encounted encounter=encounterdao.deleteEcountedbyid(eid);
		if(encounter!=null) {
			Responsestructure<Encounted> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new  ResponseEntity<Responsestructure<Encounted>>(responseStructure,HttpStatus.OK);
		}else {
			throw new  IdNotFoundException("id not found");
		}
		
	}
	public ResponseEntity<Responsestructure<Encounted>> getEncounterbyid(int eid) {
		Encounted encounter=encounterdao.getEncountedbyid(eid);
		if(encounter!=null) {
			Responsestructure<Encounted> responseStructure=new Responsestructure<>();
			responseStructure.setMessage("found succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<Responsestructure<Encounted>>(responseStructure,HttpStatus.FOUND);
		}else {
			return null;
		}
		
	}
}