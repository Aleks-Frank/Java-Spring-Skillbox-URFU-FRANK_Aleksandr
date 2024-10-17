package com.example.demo;

import org.springframework.stereotype.Component;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class BookPhone {

    private final List<Person> bookList = new ArrayList<>();

    public void addNewPerson(Person person){
        bookList.add(person);
        System.out.println(MessageFormat.format("Количество человек в списке: {0}", bookList.size()));
    }

    public void removePerson(String personRemove){
        bookList.removeIf(person -> Objects.equals(person.email, personRemove));
        System.out.println("Пользователь удален");
    }

    public void printInfoBook(){
        for (Person person : bookList){
            person.printInfo();
        }
    }

    public Person newPerson(String name, String phone, String email){
        return new Person(name, phone, email);
    }

    public void saveContact(String pathOnFile){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathOnFile))) {
            for (Person item : bookList) {
                writer.write(item.stringInfo());
                writer.newLine();
            }
            System.out.println("Данные успешно сохранены в файл: " + pathOnFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
