package com.example.demo_MVC.service;

import com.example.demo_MVC.UserContact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    List<UserContact> findAll();

    UserContact findById(Long id);

    UserContact save(UserContact contact);

    UserContact update(UserContact contact);

    void deleteById(Long id);

    void batchInsert(List<UserContact> contacts);

}
