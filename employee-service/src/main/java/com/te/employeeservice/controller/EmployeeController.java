package com.te.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.employeeservice.dto.EmployeeDto;
import com.te.employeeservice.response.AppResponse;
import com.te.employeeservice.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@GetMapping("/getEmpDet/{empId}")
	public ResponseEntity<AppResponse> getEmpDet(@PathVariable Integer empId) {
		Object empDet = employeeService.getEmpDet(empId);
		if (empDet != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(empDet).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateEmpDetails/{empId}")
	public ResponseEntity<AppResponse> updateEmpDetails(@PathVariable Integer empId,
			@RequestBody EmployeeDto employeeDto) {
		Object updateEmpDetails = employeeService.updateEmpDetails(empId, employeeDto);
		if (updateEmpDetails != null) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("SUCCESS").data(updateEmpDetails).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}
}