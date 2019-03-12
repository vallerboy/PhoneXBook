package pl.maciej.PhoneBook.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

   private List<Contact> data = new ArrayList<>();

    public void addContact(String name, String surname, String telephone){
        Contact contact = new Contact(name,surname,telephone);
        data.add(contact);
    }

    public List<Contact> getAllContacts(){
        return data;
    }


    public List<Contact> findContactsWithKeyword(String key){
        List<Contact> filteredList = new ArrayList<>();
        for (Contact datum : data) {
            if(datum.getName().contains(key) || datum.getSurname().contains(key)){
                filteredList.add(datum);
            }

        }
        return filteredList;
    }

    public void deleteByNumber(String number) {
        for (Contact datum : data) {
            if(datum.getTelephone().equals(number)){
                data.remove(datum);
                break;
            }
        }
    }
}
