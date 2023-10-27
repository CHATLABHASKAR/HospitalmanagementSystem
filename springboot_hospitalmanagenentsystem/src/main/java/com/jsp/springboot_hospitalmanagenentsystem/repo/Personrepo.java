package com.jsp.springboot_hospitalmanagenentsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Person;

public interface Personrepo extends JpaRepository<Person, Integer>{

}
