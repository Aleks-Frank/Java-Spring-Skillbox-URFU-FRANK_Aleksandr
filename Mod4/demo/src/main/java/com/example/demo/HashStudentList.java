package com.example.demo;

import lombok.Getter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Getter
@ConditionalOnProperty("app.create-student.permission")
public class HashStudentList {

    private final HashMap<UUID, String> studentList = new HashMap<>();

    public void createStudent(UUID id, Student student){
        studentList.put(id, student.toString());
    }

    public void removeStudentForIndex(UUID id){
        studentList.remove(id);
    }

    public void clearStudentList(){
        studentList.clear();
    }

    public void printStudent(){
        for(Map.Entry<UUID, String> entry : studentList.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
