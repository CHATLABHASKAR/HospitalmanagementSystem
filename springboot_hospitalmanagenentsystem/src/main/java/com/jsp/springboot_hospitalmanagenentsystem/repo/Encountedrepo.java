package com.jsp.springboot_hospitalmanagenentsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Encounted;

public interface Encountedrepo extends JpaRepository<Encounted, Integer> {

}
