package com.jsp.springboot_hospitalmanagenentsystem.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Encounted;
import com.jsp.springboot_hospitalmanagenentsystem.repo.Encountedrepo;


@Repository
public class Encounterdao {
	
	@Autowired
	private Encountedrepo encountedrepo;
	
	public Encounted saveEncounted(Encounted encounted) {
		return encountedrepo.save(encounted);
	}
	public Encounted updatEncounted(int id,Encounted encounted) {
		if(encountedrepo.findById(id).isPresent()) {
			encounted.setEid(id);
			return encountedrepo.save(encounted);
			
		}else {
			return null;
		}
	}
	public Encounted deleteEcountedbyid(int id) {
		if(encountedrepo.findById(id).isPresent()) {
			Encounted encounted =encountedrepo.findById(id).get();
			encountedrepo.deleteById(id);
			return encounted;
		}else {
			return null;
		}
	}
	public Encounted getEncountedbyid(int id) {
		
		return encountedrepo.findById(id).get();
	}

	

}
