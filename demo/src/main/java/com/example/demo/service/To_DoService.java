package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.models.To_do.To_Do;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;
import com.example.demo.repository.To_DoRepository;
import com.example.demo.service.ResourcesException.DataBaseException;
import com.example.demo.service.ResourcesException.ResourcePriorityException;
import com.example.demo.service.ResourcesException.ResourceStatusException;
import com.example.demo.service.ResourcesException.ResourcesDeadlineException;
import com.example.demo.service.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class To_DoService {
    @Autowired
    private To_DoRepository repository;

    // List all to-do...
    public List<To_Do> findAll(){
        return repository.findAll();
    }

    // List to-do by id...
    public To_Do findById(Long id){
        
        Optional<To_Do> to_do = repository.findById(id);
        return to_do.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    // Lists all to-do that have this status as a parameter...
    public List<To_Do> findAllByStatus(To_DoStatus status){
        try {
            return repository.findAllByStatus(status);
        } catch (ResourceStatusException e) {
            throw new ResourceStatusException(status);
        }
    }

    // Lists all to-do that have this priority as a parameter...
    public List<To_Do> findAllByPriority(To_DoPriority priority){
        try {
            return repository.findAllByPriority(priority);
        } catch (ResourcePriorityException e) {
            throw new ResourcePriorityException(priority);
        }
    }

    // Lists all to-do that have this deadline as a parameter...
    public List<To_Do> findAllByDeadline(Date deadline){
        try {
            return repository.findAllByDeadline(deadline);
        } catch (ResourcesDeadlineException e) {
            throw new ResourcesDeadlineException(deadline);
        }
    }

    public To_Do insert(To_Do to_do){
        return repository.save(to_do);
    }

    // Delete a to-do by id...
    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    // Update a data of to-do...
    public To_Do update(Long id, To_Do to_do){
        try {
            To_Do entity = repository.getReferenceById(id);
            updateData(entity, to_do);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    // Auxiliar funciton to update Status of to-do...
    private void updateData(To_Do entity, To_Do to_do){
        entity.setStatus(to_do.getStatus());
    }
}
