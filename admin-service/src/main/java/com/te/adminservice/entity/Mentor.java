package com.te.adminservice.entity;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.te.adminservice.util.ListToStringConverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mentor {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer mentorId;
	private String mentorName;
	private Integer empId;
	private String email;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> skills;
	
	@OneToOne(mappedBy = "mentor")
	@JsonBackReference
	private Batch trainingBatch;
}