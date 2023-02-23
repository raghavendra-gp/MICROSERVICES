package com.te.golms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.golms.entity.Employee;
import com.te.golms.entity.model.EmployeeModel;
import com.te.golms.response.AppResponse;
import com.te.golms.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/employee")
@RequiredArgsConstructor
@CrossOrigin("*")
@Validated
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping(path = "/{empId}")
	public ResponseEntity<AppResponse> getEmpDetails(@PathVariable String empId) {
		Employee empDetails = employeeService.getEmpDetails(empId);
		if (empDetails != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(empDetails).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/")
	public ResponseEntity<AppResponse> updateEmpInfo(@RequestBody EmployeeModel employeeModel) {
		boolean isUpdated = employeeService.updateEmpDetails(employeeModel.getEmpId(), employeeModel);
		if (isUpdated) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(isUpdated).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}
}

/*
 * if (empDetails.getInBatch() != null) {
 * empDetails.getInBatch().setEmployees(null); } for (MockDetails mockDetails :
 * empDetails.getMockDetails()) { mockDetails.setEmployee(null); }
 */
