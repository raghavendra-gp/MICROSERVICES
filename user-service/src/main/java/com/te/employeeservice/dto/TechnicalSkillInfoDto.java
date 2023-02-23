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
public class TechnicalSkillInfoDto {

	private String skillType;
	private String skillRating;
	private Integer yearOfExperienceOnSkill;
}
