package com.example.demo_MVC;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
public class UserContact {

    public static class Fields {
        public static final String id = "id";
        public static final String firstName = "firstName";
        public static final String lastName = "lastName";
        public static final String email = "email";
        public static final String phone = "phone";
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private int phone;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Long getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public int getPhone(){
        return phone;
    }

}
