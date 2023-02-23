package com.te.employeeservice.entity;

import javax.persistence.Entity;
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
public class BankInfo {

	@Id
	private Long accountNo;

	private String bankName;

	private String accountType;

	private String ifsc;

	private String branch;

	private String state;
}
