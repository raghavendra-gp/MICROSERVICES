package com.te.employeeservice.service;

import com.te.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	Object getEmpDet(Integer empId);

	Object updateEmpDetails(Integer empId, EmployeeDto employeeDto);

}
