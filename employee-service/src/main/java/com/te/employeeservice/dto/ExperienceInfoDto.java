package com.te.employeeservice.dto;

import java.time.LocalDate;

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
public class ExperienceInfoDto {

	private String companyName;
	private Integer yearsOfExperience;
	private LocalDate dataOfJoining;
	private LocalDate dataOfRelieving;
	private String designation;
	private String location;
}
