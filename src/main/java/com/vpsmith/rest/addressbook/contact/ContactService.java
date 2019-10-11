package com.vpsmith.rest.addressbook.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactEntity getContactById(Integer id) {
        ContactEntity contact = contactRepository.findById(id).get();
        return contact;
    }

    public List<ContactEntity> getAllContacts() {
        List<ContactEntity> contacts = new ArrayList<ContactEntity>();
        contactRepository.findAll().forEach(e -> contacts.add(e));
        return contacts;
    }

    public void updateContact(ContactEntity contact) {
        contactRepository.save(contact);
    }
}
