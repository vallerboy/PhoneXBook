package pl.maciej.PhoneBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciej.PhoneBook.model.ContactService;

@Controller
public class MainController {

    @Autowired
    ContactService contactsData;

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


    @GetMapping("/delete/{number}")
    public String delete(@PathVariable("number") String number){
        contactsData.deleteByNumber(number);
        return "redirect:/list";
    }

    @PostMapping("/list/filter")
    public String index(@RequestParam("key") String searchWord,
                        Model model){
        model.addAttribute("lists", contactsData.findContactsWithKeyword(searchWord));
        return "list";
    }


}
