package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import com.example.demo.models.Subtasks.SubTask;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;
import com.example.demo.repository.SubTaskRepository;
import com.example.demo.service.ResourcesException.DataBaseException;
import com.example.demo.service.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubTaskService {
    @Autowired
    private SubTaskRepository repository;

    public List<SubTask> findAll() {
        return repository.findAll();
    }

    // List subtask by id...
    public SubTask findById(Long id) {
        Optional<SubTask> subtask = repository.findById(id);
        return subtask.orElseThrow(()-> new ResourcesNotFoundException(id));
    }

    // Lists all subtask that have this status as a parameter...
    public List<SubTask> findAllByStatus(To_DoStatus status) {
        return repository.findAllByStatus(status);
    }

    // Lists all subtask that have this priority as a parameter...
    public List<SubTask> findAllByPriority(To_DoPriority priority) {
       return repository.findAllByPriority(priority);
    }

    // Lists all subtask that have this deadline as a parameter...
    public List<SubTask> findAllByDeadline(Date deadline) {
        return repository.findAllByDeadline(deadline);
    }

    public SubTask insert(SubTask subtask) {
        return repository.save(subtask);
    }

    // Delete a subtask by id...
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    // Update a data of subtask...
    public SubTask update(Long id, SubTask subtask) {
        try {
            SubTask entity = repository.getReferenceById(id);
            updateData(entity, subtask);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    // Auxiliar funciton to update Status of subtask...
    private void updateData(SubTask entity, SubTask subtask) {
        entity.setStatus(subtask.getStatus());
    }
}
