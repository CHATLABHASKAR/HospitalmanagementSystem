package com.jsp.springboot_hospitalmanagenentsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagenentsystem.dto.Address;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagenentsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagenentsystem.repo.Branchrepo;

@Repository
public class Branchdao {
	
	@Autowired
	private Branchrepo branchrepo;
	
	@Autowired
	private Hospitaldao hospitaldao;
	
	
	@Autowired
	private Addressdao addressdao;
	
	
	public Branch saveBranch(Branch branch,int hid,int aid) {
		Hospital hospital=hospitaldao.getHospitalbyid(hid);
		Address address=addressdao.getaddressbyid(aid);
		branch.setHospital(hospital);
		branch.setAddress(address);
		return branchrepo.save(branch);
		
	}
	public Branch updateBranch(int bid,Branch branch) {
		Branch branch2=branchrepo.findById(bid).get();
		if(branch2!=null) {
			branch.setId(bid);
			branch.setHospital(branch2.getHospital());
			branch.setAddress(branch2.getAddress());
			return branchrepo.save(branch);
				
		}else {
			return null;
		}
	}
	public Branch deleteBranch(int bid) {
		if(branchrepo.findById(bid).isPresent()) {
			Branch branch=branchrepo.findById(bid).get();
			branchrepo.deleteById(bid);
			return branch;
		}else {
			return null;
		}
	}
	public Branch getBranchbyid(int bid) {
		if(branchrepo.findById(bid).isPresent()) {
		return branchrepo.findById(bid).get();
			
		}else {
			return null;
		}
	}
	

}
