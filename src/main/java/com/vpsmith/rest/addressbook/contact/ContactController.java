package com.vpsmith.rest.addressbook.contact;


import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(path = "addressbook", produces = MediaType.APPLICATION_JSON_VALUE)
@EnableDynamoDBRepositories(basePackageClasses = ContactRepository.class)
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping(path = "contact", consumes = "application/json")
    public ResponseEntity<Void> addUser(@RequestBody ContactEntity contact) {
        HttpHeaders headers = new HttpHeaders();
        contactRepository.save(contact);
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        headers.setLocation(builder.path("/contact/{id}").buildAndExpand(contact.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(path = "contacts")
    public ResponseEntity<Iterable<ContactEntity>> getAllContacts() {
        // This returns a JSON or XML with the contacts
        Iterable<ContactEntity> contacts = contactRepository.findAll();
        return new ResponseEntity<Iterable<ContactEntity>>(contacts, HttpStatus.OK);
    }

    @GetMapping(path = "contact/{id}")
    public ResponseEntity<ContactEntity> getContactById(@PathVariable Integer id) {
        // This returns a JSON or XML with the contacts
        ContactEntity contact = contactRepository.findById(id).get();
        return new ResponseEntity<ContactEntity>(contact, HttpStatus.OK);
    }

    @PutMapping(path = "contact", consumes = "application/json")
    public ResponseEntity<ContactEntity> updateContact(@RequestBody ContactEntity contact) {
        contactRepository.save(contact);
        return new ResponseEntity<ContactEntity>(contact, HttpStatus.OK);

    }
}
