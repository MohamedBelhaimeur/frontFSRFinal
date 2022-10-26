package com.lip6.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.daos.IDAOContact;
import com.lip6.entities.*;
import com.lip6.services.IServiceContact;

@RestController
@CrossOrigin(maxAge = 3600)
class ContactController {


  
  
  private ApplicationContext context;
  
  private IServiceContact serviceContact;
  
  @Autowired
  ContactController(IServiceContact serviceContact,ApplicationContext context) {
    this.serviceContact = serviceContact;
    this.context=context;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
 /* @GetMapping("/contacts")
  List<Contact> all() {
    return repository.();
  }*/
  // end::get-aggregate-root[]

  @PostMapping("/contact")
  boolean newContact(@RequestBody Contact contact) {

	  Contact b= (Contact) context.getBean("Contact");
	 
     serviceContact.createContact(b);
    
  return   serviceContact.createContact(contact);
     
  }

  // Single item
  
  @GetMapping("/contact/{id}")
  Contact one(@PathVariable Long id) {
    
    return serviceContact.searchIDContact(id);
  }

  @PutMapping("/contact/{id}")
  boolean replaceContact(@RequestBody Contact contact, @PathVariable Long id) {
	  	return serviceContact.updateContact(contact,id);
  }

  @DeleteMapping("/contact/{id}")
  void deleteContact(@PathVariable Long id) {
    serviceContact.deleteContact(id);
  }
}