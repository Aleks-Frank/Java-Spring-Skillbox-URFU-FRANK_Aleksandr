package com.example.demo_MVC;

import com.example.demo_MVC.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserContactController {

    private final ContactService contactService;

    public UserContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("contacts", contactService.findAll());

        return "index";
    }

    @GetMapping("/contact/create")
    public String showCreateForm(Model model){
        model.addAttribute("contact", new UserContact());

        return "create";
    }

    @PostMapping("/contact/create")
    public String createTask(@ModelAttribute UserContact contact){
        contactService.save(contact);

        return "redirect:/";
    }

    @GetMapping("/contact/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        UserContact contact = contactService.findById(id);
        if(contact != null){
            model.addAttribute("contact", contact);
            return "edit";
        }

        return "redirect:/";
    }

    @PostMapping("/contact/edit")
    public String editContact(@ModelAttribute UserContact contact){
        contactService.update(contact);

        return "redirect:/";
    }

    @GetMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable Long id){
        contactService.deleteById(id);

        return "redirect:/";
    }

}
