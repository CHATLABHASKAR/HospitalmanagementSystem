package com.jsp.springboot_hospitalmanagenentsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Address;

public interface Addressrepo extends JpaRepository<Address, Integer> {

}
