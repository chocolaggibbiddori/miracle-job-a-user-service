package com.miracle.userservice.repository;

import com.miracle.userservice.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findByUserId(Long userId);

    long countByUserId(Long userId);
}
