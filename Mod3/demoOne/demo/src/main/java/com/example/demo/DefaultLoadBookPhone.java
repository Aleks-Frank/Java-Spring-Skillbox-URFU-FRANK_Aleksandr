package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
@Profile("default")
public class DefaultLoadBookPhone implements LoadBookPhone{

    File file = new File("demo/src/main/resources/default-contacts.txt");

    @Override
    public BookPhone bookList() throws IOException {
        BookPhone bookPhone = new BookPhone();
        String fileBookPath = file.getAbsolutePath();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileBookPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 3) {
                    String fullName = data[0];
                    String phoneNumber = data[1];
                    String email = data[2];
                    bookPhone.addNewPerson(new Person(fullName, phoneNumber, email));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookPhone;
    }
}
