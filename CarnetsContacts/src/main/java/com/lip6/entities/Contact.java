package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Contact {

	
	private String firstName;
	private String lastName;
	private String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContact;
	

	@OneToOne(cascade=CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name="id_address")
	private Address address;
	

	@OneToMany( cascade = CascadeType.PERSIST,mappedBy="contact",orphanRemoval = true)
	@JsonManagedReference	
	Set<PhoneNumber> phones =new HashSet<PhoneNumber>();

               
	@ManyToMany(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name="CTC_GRP",
	joinColumns=@JoinColumn(name="CTC_ID"),
	inverseJoinColumns=@JoinColumn(name="GRP_ID"))
	private Set<ContactGroup> contactGroups=new HashSet<>();
	
	
	public Set<ContactGroup> getContactGroups() {
		return contactGroups;
	}


	public void setContactGroups(Set<ContactGroup> contactGroups) {
		this.contactGroups = contactGroups;
	}


	public Contact(){
	}
	

	public Contact(String firstName, String lastName, String email, long idContact) {
		this(firstName, lastName, email);
		this.idContact = idContact;
	}


	public Contact(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Set<PhoneNumber> getPhones() {
		return phones;
	}


	public void setPhones(Set<PhoneNumber> phones) {
		this.phones=phones;
	}


	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstname){
		this.firstName = firstname;
	}
	
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastname){
		this.lastName = lastname;
	}

	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}	
	
}
