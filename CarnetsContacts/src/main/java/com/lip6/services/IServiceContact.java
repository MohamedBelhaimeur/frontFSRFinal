package com.lip6.services;

import com.lip6.daos.DAOContact;
import com.lip6.daos.IDAOContact;
import com.lip6.entities.Contact;

public interface IServiceContact {
	

	public void createContact(long id, String fname, String lname, String email);
	
	public boolean createContact(Contact c) ;
	
	
	public void deleteContact(long id) ;
	
public void updateContact(long id,String firstname, String lastname,String email);

	

public Contact searchIDContact(long id);

boolean updateContact(Contact c, Long id);

}
