package com.te.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.adminservice.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

}
