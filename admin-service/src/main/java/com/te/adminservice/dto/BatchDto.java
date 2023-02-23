package com.te.adminservice.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Convert;

import com.te.adminservice.util.ListToStringConverter;

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
public class BatchDto {

	private String batchName;
	private Integer mentorId;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> technologies;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	
}
