package com.lip6.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PhoneNumber {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String PhoneKind;
	private String PhoneNumber;

	
	@ManyToOne
	@JoinColumn(name="id_contact")
	@JsonBackReference
	private Contact contact=null;


	public PhoneNumber(){
	}



	public PhoneNumber( String phoneNumber) {
	
		this.PhoneNumber = phoneNumber;
	}
	

	public PhoneNumber( String phoneKind, String phoneNumber) {
		this.PhoneKind = phoneKind;
		this.PhoneNumber = phoneNumber;
	}
	


	public Contact getContact() {
		return contact;
	}



	public void setContact(Contact contact) {
		this.contact = contact;
	}



	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getPhoneKind() {
		return PhoneKind;
	}





	public void setPhoneKind(String phoneKind) {
		PhoneKind = phoneKind;
	}





	public String getPhoneNumber() {
		return PhoneNumber;
	}





	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}






}
