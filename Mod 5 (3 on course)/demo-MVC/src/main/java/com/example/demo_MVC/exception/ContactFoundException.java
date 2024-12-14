package com.example.demo_MVC.exception;

public class ContactFoundException extends RuntimeException {
    public ContactFoundException(String message){
        super(message);
    }
}
