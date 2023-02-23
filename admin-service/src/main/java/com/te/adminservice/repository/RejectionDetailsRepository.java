package com.te.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.adminservice.entity.RejectionDetails;

@Repository
public interface RejectionDetailsRepository extends JpaRepository<RejectionDetails, Integer> {

}
