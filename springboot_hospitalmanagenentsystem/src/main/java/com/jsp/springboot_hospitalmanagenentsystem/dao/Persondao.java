package com.jsp.springboot_hospitalmanagenentsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Person;
import com.jsp.springboot_hospitalmanagenentsystem.repo.Personrepo;

@Repository
public class Persondao {

	@Autowired
	private Personrepo personrepo;

	public Person saveperson(Person person) {
		return personrepo.save(person);
	}
	public Person updatePerson(int pid,Person person) {
		if(personrepo.findById(pid).isPresent()) {
			person.setPid(pid);
			return personrepo.save(person);

		}else {
			return null;
		}

	}
	public Person deletPerson(int pid) {
		if(personrepo.findById(pid).isPresent()) {
			Person person=personrepo.findById(pid).get();
			personrepo.deleteById(pid);
			return person;
		}else {
			return null;
		}
	}
	public Person getPersonbyid(int pid) {
		if(personrepo.findById(pid).isPresent()) {
			Person person=personrepo.findById(pid).get();
			return person;

		}
		else {
			return null;
		}
	}
	public List<Person> getallperson(){
		return personrepo.findAll();
	}
}





