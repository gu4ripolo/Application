package com.devops.webservice.components;

import org.springframework.stereotype.Component;

import com.devops.webservice.entity.ContactsEntity;
import com.devops.webservice.model.ContactsModel;

@Component("contactConverter")
public class ContactsConverter {
	
	public ContactsEntity convertToEntity(ContactsModel contactsModel) {
		ContactsEntity entity = new ContactsEntity();
		entity.setId(contactsModel.getId());
		entity.setFirstname(contactsModel.getFirstname());
		entity.setLastname(contactsModel.getLastname());
		entity.setTelephone(contactsModel.getTelephone());
		entity.setCity(contactsModel.getCity());
		return entity;
	}
	
	public ContactsModel convertToModel(ContactsEntity contactsEntity) {
		ContactsModel model = new ContactsModel();
		model.setId(contactsEntity.getId());
		model.setFirstname(contactsEntity.getFirstname());
		model.setLastname(contactsEntity.getLastname());
		model.setTelephone(contactsEntity.getTelephone());
		model.setCity(contactsEntity.getCity());
		return model;
	}
}
