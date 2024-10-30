package com.example.demo;

import com.example.demo.createLisner.CreateHolder;
import com.example.demo.removeLisner.RemoveHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Scanner;
import java.util.UUID;

@RequiredArgsConstructor
@ShellComponent
public class HashStudentListWorker {

    private final HashStudentList hashStudentList;

    private final ApplicationEventPublisher publisher;

    @ShellMethod(key = "c")
    public void createStudent(String firstName, String lastName, int age){
        UUID id = UUID.randomUUID();
        boolean idIsInStudentList = true;
        while (idIsInStudentList){
            if (hashStudentList.getStudentList().containsKey(id)){
                id = UUID.randomUUID();
            } else {
                idIsInStudentList = false;
            }
        }

        Student student = Student.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .build();

        hashStudentList.createStudent(id, student);

        publisher.publishEvent(new CreateHolder(this, student));
    }

    @ShellMethod(key = "r")
    public void removeStudentIndex(UUID id){
        hashStudentList.removeStudentForIndex(id);
        publisher.publishEvent(new RemoveHolder(this, id));
    }

    @ShellMethod(key = "cl")
    public void clear(){
        hashStudentList.clearStudentList();
        System.out.println("Список очищен");
    }

    @ShellMethod(key = "p")
    public void printStudent(){
        hashStudentList.printStudent();
    }
}
