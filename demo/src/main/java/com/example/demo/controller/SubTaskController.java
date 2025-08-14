package com.example.demo.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.models.Subtasks.SubTask;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;
import com.example.demo.service.SubTaskService;

@RestController
@RequestMapping(value = "/subtasks")
public class SubTaskController {
    @Autowired
    private SubTaskService service;

    // List all...
    @GetMapping
    public ResponseEntity<List<SubTask>> findAll(){
        List<SubTask> subtask = service.findAll();
        return ResponseEntity.ok().body(subtask);
    }

    // List by id as parameter...
    @GetMapping(value = "id/{id}")
    public ResponseEntity<SubTask> findById(@PathVariable Long id){
        SubTask subtask = service.findById(id);
        return ResponseEntity.ok().body(subtask);
    }

    // Lists all subtask that have this status as a parameter...
    @GetMapping(value = "status/{status}")
    public ResponseEntity<List<SubTask>> findAllByStatus(@PathVariable To_DoStatus status){
        List<SubTask> subtask = service.findAllByStatus(status);
        return ResponseEntity.ok().body(subtask);
    }

    // Lists all subtask that have this priority as a parameter...
    @GetMapping(value = "priority/{priority}")
    public ResponseEntity<List<SubTask>> findAllByStatus(@PathVariable To_DoPriority priority){
        List<SubTask> subtask = service.findAllByPriority(priority);
        return ResponseEntity.ok().body(subtask);
    }

    // Lists all subtask that have this deadline as a parameter...
    @GetMapping(value = "deadline/{deadline}")
    public ResponseEntity<List<SubTask>> findAllByStatus(@PathVariable @DateTimeFormat(pattern = "MM-dd-yyyy") Date deadline){
        List<SubTask> subtask = service.findAllByDeadline(deadline);
        return ResponseEntity.ok().body(subtask);
    }

    // Insert a subtask...
    @PostMapping
    public ResponseEntity<SubTask> insert(SubTask subtask){
        subtask = service.insert(subtask);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(subtask.getId()).toUri();
        return ResponseEntity.created(uri).body(subtask);
    }

    // Update a data of subtask...
    @PutMapping(value = "id/{id}")
    public ResponseEntity<SubTask> update(@PathVariable Long id, @RequestBody SubTask subtask){
        subtask = service.update(id, subtask);
        return ResponseEntity.ok().body(subtask);
    }

    // Delete a subtask by id...
    @DeleteMapping(value = "id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
