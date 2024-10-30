package com.example.demo.removeLisner;

import com.example.demo.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
public class RemoveHolder extends ApplicationEvent {

    private final UUID id;

    public RemoveHolder(Object source, UUID id) {
        super(source);
        this.id = id;
    }
}
