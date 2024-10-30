package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;

    public String toString(){
        return firstName + " " + lastName + " " + age;
    }

    public String fullName(){ return id + " " + firstName + " " + lastName + " " + age;}
}
