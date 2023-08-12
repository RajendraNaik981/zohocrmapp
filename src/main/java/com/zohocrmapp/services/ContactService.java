package com.zohocrmapp.services;

import java.util.List;

import com.zohocrmapp.entities.Contacts;

public interface ContactService {
	public void saveContact(Contacts contact);

	public List<Contacts> listAllContacts();

	public Contacts getContactById(long id);

}
