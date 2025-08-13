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

import com.example.demo.models.To_do.To_Do;
import com.example.demo.models.To_do.Enums.To_DoPriority;
import com.example.demo.models.To_do.Enums.To_DoStatus;
import com.example.demo.service.To_DoService;

@RestController
@RequestMapping(value = "/to-do")
public class To_DoController {
    @Autowired
    private To_DoService service;

    // List all...
    @GetMapping
    public ResponseEntity<List<To_Do>> findAll(){
        List<To_Do> to_do = service.findAll();
        return ResponseEntity.ok().body(to_do);
    }

    // List by id as parameter...
    @GetMapping(value = "id/{id}")
    public ResponseEntity<To_Do> findById(@PathVariable Long id){
        To_Do to_do = service.findById(id);
        return ResponseEntity.ok().body(to_do);
    }

    // Lists all to-do that have this status as a parameter...
    @GetMapping(value = "status/{status}")
    public ResponseEntity<List<To_Do>> findAllByStatus(@PathVariable To_DoStatus status){
        List<To_Do> to_do = service.findAllByStatus(status);
        return ResponseEntity.ok().body(to_do);
    }

    // Lists all to-do that have this priority as a parameter...
    @GetMapping(value = "priority/{priority}")
    public ResponseEntity<List<To_Do>> findAllByStatus(@PathVariable To_DoPriority priority){
        List<To_Do> to_do = service.findAllByPriority(priority);
        return ResponseEntity.ok().body(to_do);
    }

    // Lists all to-do that have this deadline as a parameter...
    @GetMapping(value = "deadline/{deadline}")
    public ResponseEntity<List<To_Do>> findAllByStatus(@PathVariable @DateTimeFormat(pattern = "MM-dd-yyyy") Date deadline){
        List<To_Do> to_do = service.findAllByDeadline(deadline);
        return ResponseEntity.ok().body(to_do);
    }

    // Insert a to-do...
    @PostMapping
    public ResponseEntity<To_Do> insert(To_Do to_do){
        to_do = service.insert(to_do);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(to_do.getId()).toUri();
        return ResponseEntity.created(uri).body(to_do);
    }

    // Update a data of to-do...
    @PutMapping(value = "id/{id}")
    public ResponseEntity<To_Do> update(@PathVariable Long id, @RequestBody To_Do to_do){
        to_do = service.update(id, to_do);
        return ResponseEntity.ok().body(to_do);
    }

    // Delete a to-do by id...
    @DeleteMapping(value = "id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
