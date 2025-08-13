package com.example.demo.service.ResourcesException;

public class ResourcesDeadlineException extends RuntimeException{

    public ResourcesDeadlineException(Object deadline){
        super("Resource deadline not found: " + deadline);
    }
}
