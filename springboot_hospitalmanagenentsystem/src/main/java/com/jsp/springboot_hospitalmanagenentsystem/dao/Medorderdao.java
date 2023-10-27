package com.jsp.springboot_hospitalmanagenentsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Encounted;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Medorder;
import com.jsp.springboot_hospitalmanagenentsystem.repo.Medorderrepo;

@Repository
public class Medorderdao {
	
	@Autowired
	private Medorderrepo medorderrepo;
	
	@Autowired
	private Encounterdao encounteddao;
	
	public Medorder saveMedorder(Medorder medorder,int eid) {
		Encounted encounted=encounteddao.getEncountedbyid(eid);
		medorder.setEncounter(encounted);
		return medorderrepo.save(medorder);
	}
	public Medorder updateMedorder(int id,Medorder medorder) {
		if(medorderrepo.findById(id).isPresent()) {
			medorder.setMid(id);
			return medorderrepo.save(medorder);
		}else {
			return null;
		}
	}
	public Medorder deleteMedorderbyid(int id) {
		if(medorderrepo.findById(id).isPresent()) {
		   Medorder medorder=medorderrepo.findById(id).get();
		   medorderrepo.deleteById(id);
		   return medorder;
		}else {
			return null;
			
		}
			
	}
	public Medorder getMedorderbyid(int id) {
		return medorderrepo.findById(id).get();
	}

}
