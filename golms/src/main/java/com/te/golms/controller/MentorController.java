package com.te.golms.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.golms.entity.MockDetailsModel;
import com.te.golms.entity.model.AttendenceInfoModel;
import com.te.golms.entity.model.BatchModel;
import com.te.golms.entity.model.EmpStatusModel;
import com.te.golms.entity.model.MockModel;
import com.te.golms.response.AppResponse;
import com.te.golms.service.EmployeeService;
import com.te.golms.service.MentorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/mentor")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MentorController {

	private final MentorService mentorService;
	private final EmployeeService employeeService;

	@GetMapping(path = "/batches")
	public ResponseEntity<AppResponse> getBatch(Principal principal) {
		String mentorId = principal.getName();
		BatchModel batchData = mentorService.getBatchData(mentorId);
		if (batchData != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(batchData).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/batches/mock/rating/{empId}")
	public ResponseEntity<AppResponse> mockRating(@PathVariable String empId,
			@RequestBody MockDetailsModel mockDetailsModel) {
		boolean isAdded = mentorService.addEmpMockData(empId, mockDetailsModel);
		if (isAdded) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(isAdded).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/batches/employee/attendence")
	public ResponseEntity<AppResponse> attendence(@RequestBody AttendenceInfoModel attendenceInfoModel) {
		boolean attendenceAdded = employeeService.addAttendenceInfo(attendenceInfoModel);
		if (attendenceAdded) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("SUCCESS").data(attendenceAdded).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/mock/{mentorId}")
	public ResponseEntity<AppResponse> createNewMock(@PathVariable String mentorId, @RequestBody MockModel mockModel) {
		boolean isMockCreated = mentorService.createNewMock(mentorId, mockModel);
		if (isMockCreated) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("SUCCESS").data(isMockCreated).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/batches/employee/status")
	public ResponseEntity<AppResponse> changeEmployeeStatus(@RequestBody EmpStatusModel empStatusModel) {
		boolean isStatusChanged = mentorService.changeEmployeeStatus(empStatusModel);
		if (isStatusChanged) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("SUCCESS").data(isStatusChanged).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}
}
