package com.jsp.springboot_hospitalmanagenentsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Branch;

public interface Branchrepo extends JpaRepository<Branch, Integer> {

}
