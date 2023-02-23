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
public class AddressInfoDto {

	private String doorNo;
	private String street;
	private String locality;
	private String city;
	private Integer pincode;
	private String landmark;
	private String state;
	private String addressType;
}
