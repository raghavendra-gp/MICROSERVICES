package com.te.golms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.golms.entity.model.EmployeeModel;
import com.te.golms.entity.model.LoginModel;
import com.te.golms.entity.model.PasswordResetModel;
import com.te.golms.response.AppResponse;
import com.te.golms.service.GoLmsUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
	private final GoLmsUserService goLmsUserService;
	private final AuthenticationManager authenticationManager;

	@PostMapping(path = "/register")
	public ResponseEntity<AppResponse> register(@RequestBody EmployeeModel employeeModel) {
		EmployeeModel saveEmployee = goLmsUserService.saveEmployee(employeeModel);
		if (saveEmployee != null) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("SUCCESS").data(saveEmployee).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/login")
	public ResponseEntity<AppResponse> login(@RequestBody LoginModel login) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getEmpId(), login.getPassword()));
		goLmsUserService.setLastLogin(login.getEmpId());
		if (goLmsUserService.checkPasswordReset(login.getEmpId())) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("SUCCESS").data(login.getEmpId()).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/getMessage")
	public String getMessage() {
		return "Got message!";
	}

	@PostMapping(path = "/passwordReset")
	public ResponseEntity<AppResponse> passwordReset(@RequestBody PasswordResetModel reset) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(reset.getEmpId(), reset.getOldPassword()));
		boolean lmsUser = goLmsUserService.passwordReset(reset);
		if (lmsUser) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(lmsUser).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

}
