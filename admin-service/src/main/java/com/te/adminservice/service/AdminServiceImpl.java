package com.te.adminservice.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.te.adminservice.dto.BatchDto;
import com.te.adminservice.dto.MentorDto;
import com.te.adminservice.dto.UpdateBatchDto;
import com.te.adminservice.entity.Batch;
import com.te.adminservice.entity.Mentor;
import com.te.adminservice.repository.BatchRepository;
import com.te.adminservice.repository.MentorRepository;

import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final BatchRepository batchRepository;
	private final ModelMapper modelMapper;
	private final MentorRepository mentorRepository;

	@Override
	public BatchDto saveBatch(BatchDto batchDto) {

		Batch batch = new Batch();
		modelMapper.map(batchDto, batch);

		Optional<Mentor> findById = mentorRepository.findById(batchDto.getMentorId());
		if (findById.isPresent()) {
			Mentor mentor = findById.get();
			batch.setMentorName(mentor.getMentorName());
			batch.setMentor(mentor);
			batchRepository.save(batch);
			return batchDto;
		}
		return null;

	}

	@Override
	public MentorDto saveMentor(MentorDto mentorDto) {
		Mentor mentor = new Mentor();
		modelMapper.map(mentorDto, mentor);

		Mentor save = mentorRepository.save(mentor);
		mentorDto.setMentorId(save.getMentorId());
		return mentorDto;

	}

	@Override
	public UpdateBatchDto updateBatch(UpdateBatchDto updateBatchDto) {

		Optional<Batch> findById = batchRepository.findById(updateBatchDto.getBatchId());
		if (findById.isPresent()) {
			Batch batch = findById.get();

			Optional<Mentor> findByMentorId = mentorRepository.findById(updateBatchDto.getMentorId());
			if (findByMentorId.isPresent()) {

				if (Objects.equals(findByMentorId.get().getMentorId(), updateBatchDto.getMentorId())) {
					modelMapper.map(updateBatchDto, batch);
					batchRepository.save(batch);
					return updateBatchDto;
				}
				modelMapper.map(updateBatchDto, batch);
				batch.setMentor(findByMentorId.get());
				batch.setMentorName(findByMentorId.get().getMentorName());
				batchRepository.save(batch);
				return updateBatchDto;

			}
			return null;

		}
		return null;
	}

	@Override
	public List<Batch> getBatchList() {
		return batchRepository.findAll();
	}

	@Override
	public List<Mentor> getMentorList() {
		return mentorRepository.findAll();
	}

	@Override
	public String deleteBatch(Integer batchId) {

		Optional<Batch> findById = batchRepository.findById(batchId);
		if (findById.isPresent()) {
		batchRepository.delete(findById.get());
		return "Batch Deletion Successfull";
		}
		return "Batch Deletion Unsuccessfull";
	}

	@Override
	public String deleteMentor(Integer mentorId) {
		Optional<Mentor> findById = mentorRepository.findById(mentorId);
		if (findById.isPresent()) {
			mentorRepository.delete(findById.get());
			return "Mentor Deletion Successfull";
		}
		return "Mentor Deletion Unsuccessfull";
	}

}