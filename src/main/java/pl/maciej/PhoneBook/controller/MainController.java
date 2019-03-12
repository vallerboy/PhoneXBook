package pl.maciej.PhoneBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciej.PhoneBook.model.ContactsData;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ContactsData contactsData;

    @GetMapping("/phonebook")
    public String phone(){
        return "phonebook";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("lists", contactsData.getAllContacts());
        return "list";


    }

    @PostMapping("/phonebook")

    public String phone(@RequestParam("name") String name,
                        @RequestParam("surname") String surname,
                        @RequestParam("telephone") String telephone,
                        Model model) {

         contactsData.addContact(name,surname,telephone);

                return "phonebook";

    }



}
