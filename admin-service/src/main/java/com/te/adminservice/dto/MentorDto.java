package com.te.adminservice.dto;

import java.util.List;

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
public class MentorDto {

	private String mentorName;
	private Integer mentorId;
	private Integer empId;
	private String email;
	private List<String> skills;
}
