package com.te.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.employeeservice.entity.PrimaryInfo;

@Repository
public interface UserRepository extends JpaRepository<PrimaryInfo, Integer> {

	List<PrimaryInfo> findByEmpId(Integer empId);

}
