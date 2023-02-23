package com.te.employeeservice.service;

import java.util.List;

import com.te.employeeservice.dto.EmployeeDto;
import com.te.employeeservice.entity.PrimaryInfo;

public interface UserService {

	Integer register(EmployeeDto employeeDto);

	List<PrimaryInfo> getEmpDet(Integer empId);

	EmployeeDto updateEmpDetails(Integer empId, EmployeeDto employeeDto);

}
