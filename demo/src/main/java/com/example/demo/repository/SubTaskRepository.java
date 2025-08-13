package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Subtasks.SubTask;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
    List<SubTask> findAllByStatus(To_DoStatus status);
    List<SubTask> findAllByPriority(To_DoPriority priority);
    List<SubTask> findAllByDeadline(Date deadline);
}
