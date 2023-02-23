package com.te.employeeservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.employeeservice.dto.EmployeeDto;
import com.te.employeeservice.entity.PrimaryInfo;
import com.te.employeeservice.response.AppResponse;
import com.te.employeeservice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/registerEmployee")
	public ResponseEntity<AppResponse> register(@RequestBody EmployeeDto employeeDto) {
		Integer register = userService.register(employeeDto);
		if (register != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(register).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	// Get method to fetch employee detail by empId
	
	@GetMapping("/getEmpDet/{empId}")
	public ResponseEntity<AppResponse> getEmpDet(@PathVariable Integer empId) {
		List<PrimaryInfo> empDet = userService.getEmpDet(empId);
		if (empDet != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(empDet).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updateEmpDetails/{empId}")
	public ResponseEntity<AppResponse> updateEmpDetails(@PathVariable Integer empId, @RequestBody EmployeeDto employeeDto) {
		EmployeeDto updateEmpDetails = userService.updateEmpDetails(empId, employeeDto);
		if (updateEmpDetails != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(updateEmpDetails).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}
}