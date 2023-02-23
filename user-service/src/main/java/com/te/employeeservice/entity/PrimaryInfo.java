package com.te.employeeservice.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrimaryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
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

	@OneToOne(cascade = CascadeType.ALL)
	private SecondaryInfo secondaryInfo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "educationDetails")
	private List<EducationalInfo> educationDetails = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private List<AddressInfo> address;

	@OneToOne(cascade = CascadeType.ALL)
	private BankInfo bankDetails;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "technicalSkill")
	private Set<TechnicalSkillInfo> technicalSkill = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "experience")
	private List<ExperienceInfo> experience = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contacts")
	private List<ContactInfo> contacts = new ArrayList<>();

}
