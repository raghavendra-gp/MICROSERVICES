package com.te.employeeservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SecondaryInfo {
	
	@Id
	private String panNo;
	private String aadhaarNo;
	private String fatherName;
	private String motherName;
	private String spouseName;
	private String passportNo;
	private String maritalStatus;

}
