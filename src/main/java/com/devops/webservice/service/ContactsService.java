package com.devops.webservice.service;

import java.util.List;

import com.devops.webservice.entity.ContactsEntity;
import com.devops.webservice.model.ContactsModel;

public interface ContactsService {
	
	public abstract ContactsModel addContact(ContactsModel contactModel);
	public abstract List<ContactsModel> listAllContacts();
	public abstract ContactsEntity findContactById(int id);
	public abstract void removeContact(int id);
	public abstract ContactsModel findContactByIdModel(int id);
}
