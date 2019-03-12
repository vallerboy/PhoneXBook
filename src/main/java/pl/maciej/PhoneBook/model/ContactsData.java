package pl.maciej.PhoneBook.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContactsData {

   private List<Contact> data = new ArrayList<>();

    public void addContact(String name, String surname, String telephone){
        Contact contact = new Contact(name,surname,telephone);
        data.add(contact);
    }

    public List<Contact> getAllContacts(){
        return data;
    }


}
