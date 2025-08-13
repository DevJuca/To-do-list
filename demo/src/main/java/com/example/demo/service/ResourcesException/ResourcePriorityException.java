package com.example.demo.service.ResourcesException;

public class ResourcePriorityException extends RuntimeException {
    
    public ResourcePriorityException(Object priority){
        super("Resource priority not found: " + priority);
    }
}
