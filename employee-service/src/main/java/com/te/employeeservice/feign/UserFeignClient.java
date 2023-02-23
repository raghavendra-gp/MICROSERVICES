package com.te.employeeservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.te.employeeservice.dto.EmployeeDto;
import com.te.employeeservice.response.AppResponse;

@FeignClient(value = "user-client", url = "http://localhost:9003/user/")
public interface UserFeignClient {

	@GetMapping("/getEmpDet/{empId}")
	public ResponseEntity<AppResponse> getEmpDet(@PathVariable Integer empId);
	
	@PutMapping("/updateEmpDetails/{empId}")
	public ResponseEntity<AppResponse> updateEmpDetails(@PathVariable Integer empId, @RequestBody EmployeeDto employeeDto);

}
