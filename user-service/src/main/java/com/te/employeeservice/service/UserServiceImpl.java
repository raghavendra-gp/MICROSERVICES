package com.te.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.te.employeeservice.dto.EmployeeDto;
import com.te.employeeservice.entity.PrimaryInfo;
import com.te.employeeservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Override
	public Integer register(EmployeeDto employeeDto) {
		PrimaryInfo info = new PrimaryInfo();

		modelMapper.map(employeeDto, info);
		return userRepository.save(info).getEmpId();
	}

	@Override
	public List<PrimaryInfo> getEmpDet(Integer empId) {
		return userRepository.findByEmpId(empId);
	}

	@Override
	public EmployeeDto updateEmpDetails(Integer empId, EmployeeDto employeeDto) {
		Optional<PrimaryInfo> primaryInfo = userRepository.findById(empId);

		if (primaryInfo.isPresent()) {
			PrimaryInfo info = primaryInfo.get();
			modelMapper.map(employeeDto, info );
			userRepository.save(info);
			return employeeDto;
		}
		return null;
	}

}
