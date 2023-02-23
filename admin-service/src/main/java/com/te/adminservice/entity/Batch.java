package com.te.adminservice.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
public class Batch {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer batchId;
	private String batchName;
	private String mentorName;

	@Convert(converter = ListToStringConverter.class)
	private List<String> technologies;

	private LocalDate startDate;

	private LocalDate endDate;

	private String status;

	
	@OneToOne
	private Mentor mentor;

}
