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
public class BankInfoDto {

	private Long accountNo;
	private String bankName;
	private String accountType;
	private String ifsc;
	private String branch;
	private String state;
}