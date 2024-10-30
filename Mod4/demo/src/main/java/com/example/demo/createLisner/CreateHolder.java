package com.example.demo.createLisner;

import com.example.demo.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreateHolder extends ApplicationEvent {

    private final Student student;

    public CreateHolder(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
