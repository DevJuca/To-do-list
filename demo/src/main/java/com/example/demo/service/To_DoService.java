package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.To_do.To_Do;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;
import com.example.demo.repository.To_DoRepository;

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
        return to_do.get();
    }

    // Lists all to-do that have this status as a parameter...
    public List<To_Do> findAllByStatus(To_DoStatus status){
        return repository.findAllByStatus(status);
    }

    // Lists all to-do that have this priority as a parameter...
    public List<To_Do> findAllByPriority(To_DoPriority priority){
        return repository.findAllByPriority(priority);
    }

    // Lists all to-do that have this deadline as a parameter...
    public List<To_Do> findAllByDeadline(Date deadline){
        return repository.findAllByDeadline(deadline);
    }

    public To_Do insert(To_Do to_do){
        return repository.save(to_do);
    }

    // Delete a to-do by id...
    public void delete(Long id){
        repository.deleteById(id);
    }

    // Update a data of to-do...
    public To_Do update(Long id, To_Do to_do){
        To_Do entity = repository.getReferenceById(id);
        updateData(entity, to_do);
        return repository.save(entity);
    }

    // Auxiliar funciton to update Status of to-do...
    private void updateData(To_Do entity, To_Do to_do){
        entity.setStatus(to_do.getStatus());
    }
}
