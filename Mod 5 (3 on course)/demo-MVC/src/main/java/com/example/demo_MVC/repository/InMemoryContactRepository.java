package com.example.demo_MVC.repository;

import com.example.demo_MVC.UserContact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class InMemoryContactRepository implements ContactRepository{

    private final List<UserContact> contacts = new ArrayList<>();

    @Override
    public List<UserContact> findAll() {
        return contacts;
    }

    @Override
    public Optional<UserContact> findById(Long id) {
        return contacts.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public UserContact save(UserContact contact) {
        contact.setId(System.currentTimeMillis());
        contacts.add(contact);
        return null;
    }

    @Override
    public UserContact update(UserContact contact) {
        UserContact existedContact = findById(contact.getId()).orElse(null);
        if (existedContact != null){
            existedContact.setFirstName(contact.getFirstName());
            existedContact.setLastName(contact.getLastName());
            existedContact.setPhone(contact.getPhone());
            existedContact.setEmail(contact.getEmail());
        }

        return existedContact;
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(contacts::remove);
    }

    @Override
    public void batchInsert(List<UserContact> contacts) {
        this.contacts.addAll(contacts);
    }
}
