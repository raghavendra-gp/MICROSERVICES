package com.te.adminservice.controller;

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

import com.te.adminservice.dto.BatchDto;
import com.te.adminservice.dto.MentorDto;
import com.te.adminservice.dto.UpdateBatchDto;
import com.te.adminservice.entity.Batch;
import com.te.adminservice.entity.Mentor;
import com.te.adminservice.response.AppResponse;
import com.te.adminservice.service.AdminService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

	private final AdminService adminService;

	@PostMapping("/saveBatch")
	public ResponseEntity<AppResponse> saveBatch(@RequestBody BatchDto batchDto) {

		BatchDto saveBatch = adminService.saveBatch(batchDto);
		if (saveBatch != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(saveBatch).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/saveMentor")
	public ResponseEntity<AppResponse> saveMentor(@RequestBody MentorDto mentorDto) {
		MentorDto saveMentor = adminService.saveMentor(mentorDto);
		if (saveMentor != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(saveMentor).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateBatch")
	public ResponseEntity<AppResponse> updateBatch(@RequestBody UpdateBatchDto updateBatchDto) {
		UpdateBatchDto updateBatch = adminService.updateBatch(updateBatchDto);
		if (updateBatch != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(updateBatch).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getBatchList")
	public ResponseEntity<AppResponse> getBatchList() {
		List<Batch> batchList = adminService.getBatchList();
		if (batchList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(batchList).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getMentorList")
	public ResponseEntity<AppResponse> getMentorList() {
		List<Mentor> mentorList = adminService.getMentorList();
		if (mentorList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message("SUCCESS").data(mentorList).build(),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).message("FAIL").data(null).build(),
				HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/deleteBatch/{batchId}")
	public ResponseEntity<AppResponse> deleteBatch(@PathVariable Integer batchId) {
		return new ResponseEntity<>(
				AppResponse.builder().error(false).message("SUCCESS").data(adminService.deleteBatch(batchId)).build(),
				HttpStatus.OK);

	}

	@GetMapping("/deleteMentor/{mentorId}")
	public ResponseEntity<AppResponse> deleteMentor(@PathVariable Integer mentorId) {
		return new ResponseEntity<>(
				AppResponse.builder().error(false).message("SUCCESS").data(adminService.deleteMentor(mentorId)).build(),
				HttpStatus.OK);
	}
	
	public ResponseEntity<AppResponse> saveRequest() {
		
	}
}
