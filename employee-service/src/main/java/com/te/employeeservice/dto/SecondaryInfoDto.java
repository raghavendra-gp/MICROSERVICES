package com.te.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecondaryInfoDto {

	private String panNo;
	private String aadhaarNo;
	private String fatherName;
	private String motherName;
	private String spouseName;
	private String passportNo;
	private String maritalStatus;
}
