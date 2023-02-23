package com.te.adminservice.service;

import java.util.List;

import com.te.adminservice.dto.BatchDto;
import com.te.adminservice.dto.MentorDto;
import com.te.adminservice.dto.UpdateBatchDto;
import com.te.adminservice.entity.Batch;
import com.te.adminservice.entity.Mentor;

public interface AdminService {

	BatchDto saveBatch(BatchDto batchDto);

	MentorDto saveMentor(MentorDto mentorDto);

	UpdateBatchDto updateBatch(UpdateBatchDto updateBatchDto);

	List<Batch> getBatchList();

	List<Mentor> getMentorList();

	String deleteBatch(Integer batchId);

	String deleteMentor(Integer mentorId);

}