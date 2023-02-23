package com.te.employeeservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class TechnicalSkillInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer skillId;

	private String skillType;

	private String skillRating;

	private Integer yearOfExperienceOnSkill;
}
