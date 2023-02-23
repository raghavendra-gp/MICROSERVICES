package com.te.employeeservice.service;

import org.springframework.stereotype.Service;

import com.te.employeeservice.dto.EmployeeDto;
import com.te.employeeservice.feign.UserFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final UserFeignClient userFeignClient;

	@Override
	public Object getEmpDet(Integer empId) {

		Object data = userFeignClient.getEmpDet(empId).getBody().getData();
		if (data != null ) {
			return data;
		}
		return null;
	}

	@Override
	public Object updateEmpDetails(Integer empId, EmployeeDto employeeDto) {
		Object data = userFeignClient.updateEmpDetails(empId, employeeDto).getBody().getData();
		if (data != null) {
			return data;
		}
		return null;
	}

}