package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class BookPhoneComponent {
    LoadBookPhone loadBookPhone;
    private BookPhone bookPhone;

    @Value("${app.filePath}")
    private String filePath;

    public BookPhoneComponent(LoadBookPhone loadBookPhone){
        this.loadBookPhone = loadBookPhone;
    }

    public void work(){
        try{
            bookPhone = loadBookPhone.bookList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Info infoConn = new Info();
        infoConn.infoPrintInConsole();

        Scanner scanner = new Scanner(System.in);

        label:
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "Add":
                    System.out.println("Ввиде имя;номер телефона;почта");
                    String[] info = scanner.nextLine().split(";");
                    bookPhone.addNewPerson(bookPhone.newPerson(info[0], info[1], info[2]));
                    break;
                case "Remove":
                    System.out.println("Ввиде почту");
                    String emailRemove = scanner.nextLine();
                    bookPhone.removePerson(emailRemove);
                    break;
                case "PrintInfo":
                    bookPhone.printInfoBook();
                    break;
                case "Save":
                    bookPhone.saveContact(filePath);
                    break;
                case "Exit":
                    System.out.println("Спасибо за использование");
                    break label;
                default:
                    System.out.println("Не правильная команда");
                    break;
            }
        }
    }
}
