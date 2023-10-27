package com.jsp.springboot_hospitalmanagenentsystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="State cannot be null or blank")
	private String state;
	@NotBlank(message="City cannot be null or blank")
	private String city;
	@Min(000001)
	@Max(999999)
	private long pincode;

}
