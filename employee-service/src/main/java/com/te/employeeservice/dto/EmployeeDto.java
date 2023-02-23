package com.te.employeeservice.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class EmployeeDto {

	private String empName;
	private String email;
	private LocalDate dateOfBirth;
	private LocalDate dateOfJoining;
	private String designation;
	private String nationality;	
	private String gender;
	private String bloodGroup;
	private String degree;
	private String status;
	
	
	private SecondaryInfoDto secondaryInfo;
	private List<EducationalInfoDto> educationDetails = new ArrayList<>();
	private List<AddressInfoDto> address;
	private BankInfoDto bankDetails;
	private Set<TechnicalSkillInfoDto> technicalSkill = new HashSet<>();
	private List<ExperienceInfoDto> experience = new ArrayList<>();
	private List<ContactInfoDto> contacts = new ArrayList<>();
}
