package com.example.demo.service.ResourcesException;

public class ResourcesNotFoundException extends RuntimeException {
    
    public ResourcesNotFoundException(Object id){
        super("Resource not found: " + id);
    }
}
