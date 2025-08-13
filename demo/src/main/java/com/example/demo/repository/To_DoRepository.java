package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.To_do.To_Do;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;

public interface To_DoRepository extends JpaRepository<To_Do, Long> {
    List<To_Do> findAllByStatus(To_DoStatus status);
    List<To_Do> findAllByPriority(To_DoPriority priority);
    List<To_Do> findAllByDeadline(Date deadline);
}

