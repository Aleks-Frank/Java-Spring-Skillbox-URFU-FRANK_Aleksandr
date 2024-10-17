package com.example.demo;

public class Person {

    public String fullName;

    public String phoneNumber;

    public String email;

    public Person(String fullName, String phoneNumber, String email){
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String stringInfo(){
        return fullName + ";" + phoneNumber + ";" + email;
    }

    public void printInfo(){
        System.out.println(fullName + '|' + phoneNumber + '|' + email);
    }

}
