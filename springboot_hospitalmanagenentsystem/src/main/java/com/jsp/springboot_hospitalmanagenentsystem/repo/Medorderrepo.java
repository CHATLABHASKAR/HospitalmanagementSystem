package com.jsp.springboot_hospitalmanagenentsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Medorder;

public interface Medorderrepo extends JpaRepository<Medorder, Integer>{

}
