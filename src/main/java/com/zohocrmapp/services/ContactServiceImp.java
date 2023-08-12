package com.zohocrmapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrmapp.entities.Contacts;
import com.zohocrmapp.repositories.ContactRepository;
@Service
public class ContactServiceImp implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void saveContact(Contacts contact) {
		contactRepo.save(contact);
	}

	@Override
	public List<Contacts> listAllContacts() {
		List<Contacts> AllContacts = contactRepo.findAll();
		return AllContacts;
	}

	@Override
	public Contacts getContactById(long id) {
		Optional<Contacts> findById = contactRepo.findById(id);
		Contacts contact = findById.get();
		return contact;
	}

}
