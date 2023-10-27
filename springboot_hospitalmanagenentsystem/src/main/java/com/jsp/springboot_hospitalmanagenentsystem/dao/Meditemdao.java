package com.jsp.springboot_hospitalmanagenentsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Meditems;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Medorder;
import com.jsp.springboot_hospitalmanagenentsystem.repo.Meditemssrepo;

@Repository
public class Meditemdao {
	
	@Autowired
	private Meditemssrepo meditemsrepo;
	
	@Autowired
	private Medorderdao  medorderdao;
	
	public Meditems saveMeditems(Meditems meditems, int mid) {
		Medorder medorder=medorderdao.getMedorderbyid(mid);
		meditems.setMedorder(medorder);
		return meditemsrepo.save(meditems);
	}
	public Meditems updateMeditems(int id, Meditems meditems) {
		if(meditemsrepo.findById(id).isPresent()) {
			meditems.setId(id);
			return meditemsrepo.save(meditems);
		}else {
			return null;
		}
	}
	public Meditems deleteMeditems(int id) {
		if(meditemsrepo.findById(id).isPresent()) {
			Meditems meditems=meditemsrepo.findById(id).get();
			meditemsrepo.deleteById(id);
			return meditems;
			
		}else {
			return null;
		}
	}
	public Meditems getMeditemsbyid(int id) {
	return meditemsrepo.findById(id).get();
	}
	
	

}
