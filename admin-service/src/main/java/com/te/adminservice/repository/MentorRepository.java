package com.te.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.adminservice.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {

}
