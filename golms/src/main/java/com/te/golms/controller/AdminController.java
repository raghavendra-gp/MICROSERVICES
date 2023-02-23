package com.te.golms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.golms.entity.Request;
import com.te.golms.entity.model.AddEmployeeToBatchModel;
import com.te.golms.entity.model.BatchModel;
import com.te.golms.entity.model.MentorModel;
import com.te.golms.entity.model.RejectRegisterRequestModel;
import com.te.golms.response.AppResponse;
import com.te.golms.response.BatchResponseModel;
import com.te.golms.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
@Validated
public class AdminController {

	private final AdminService adminService;


	@GetMapping(path = "/batches")
	public ResponseEntity<AppResponse> getBatchList() {
		List<BatchResponseModel> batcheList = adminService.getBatcheList();
		if (batcheList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(batcheList).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(batcheList).build(),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/requests")
	public ResponseEntity<AppResponse> getRequestList() {
		List<Request> requestList = adminService.getRequestList();
		if (requestList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(requestList).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/mentors")
	public ResponseEntity<AppResponse> getMentorList() {
		List<MentorModel> mentorList = adminService.getMentorList();
		if (mentorList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(mentorList).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}


	@PostMapping(path = "/batch")
	public ResponseEntity<AppResponse> saveBatch(@RequestBody BatchModel batchModel) {
		BatchModel saveBatch = adminService.saveBatch(batchModel);
		if (saveBatch != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(saveBatch).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/mentor")
	public ResponseEntity<AppResponse> saveMentor(@RequestBody MentorModel mentorModel) {
		MentorModel saveMentor = adminService.saveMentor(mentorModel);
		if (saveMentor != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(saveMentor).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}


	@PutMapping(path = "/batch")
	public ResponseEntity<AppResponse> updateBatch(@RequestBody BatchModel batchModel) {
		BatchModel updateBatch = adminService.updateBatch(batchModel);
		if (updateBatch != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(updateBatch).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/approve")
	public ResponseEntity<AppResponse> addEmployeeToBatchModel(
			@RequestBody AddEmployeeToBatchModel addEmployeeToBatchModel) {
		boolean isAdded = adminService.addEmployeeToBatchModel(addEmployeeToBatchModel);
		if (isAdded) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(isAdded).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/reject")
	public ResponseEntity<AppResponse> rejectRequest(@RequestBody RejectRegisterRequestModel rejectRequest) {
		boolean request = adminService.rejectRequest(rejectRequest);
		if (request) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(request).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}


	@DeleteMapping(path = "/batch/{batchName}")
	public ResponseEntity<AppResponse> deleteBatch(@PathVariable String batchName) {
		boolean deleteBatch = adminService.deleteBatch(batchName);
		if (deleteBatch) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(deleteBatch).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(path = "/mentor/{mentorId}")
	public ResponseEntity<AppResponse> deleteMentor(@PathVariable String mentorId) {
		boolean deleteMentor = adminService.deleteMentor(mentorId);
		if (deleteMentor) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).message("SUCCESS").data(deleteMentor).build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}
}