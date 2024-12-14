package com.example.demo_MVC.service;

import com.example.demo_MVC.UserContact;
import com.example.demo_MVC.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<UserContact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public UserContact findById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public UserContact save(UserContact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public UserContact update(UserContact contact) {
        return contactRepository.update(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public void batchInsert(List<UserContact> contacts) {

        contactRepository.batchInsert(contacts);
    }
}
