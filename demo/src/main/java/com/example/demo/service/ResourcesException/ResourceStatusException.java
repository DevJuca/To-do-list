package com.example.demo.service.ResourcesException;

public class ResourceStatusException extends RuntimeException {
    public ResourceStatusException(Object status){
        super("Resouce status not found: " + status);
    }
}
