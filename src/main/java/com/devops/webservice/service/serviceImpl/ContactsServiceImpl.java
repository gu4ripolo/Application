package com.devops.webservice.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.devops.webservice.components.ContactsConverter;
import com.devops.webservice.entity.ContactsEntity;
import com.devops.webservice.model.ContactsModel;
import com.devops.webservice.repository.ContactsRepository;
import com.devops.webservice.service.ContactsService;

@Service("contactsServiceImpl")
public class ContactsServiceImpl implements ContactsService {

	@Autowired
	@Qualifier("contactsRepository")
	private ContactsRepository contactsRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactsConverter contactsConverter;

	@Override
	public ContactsModel addContact(ContactsModel contactModel) {
		ContactsEntity entity = contactsRepository.save(contactsConverter.convertToEntity(contactModel));
		return contactsConverter.convertToModel(entity);
	}

	@Override
	public List<ContactsModel> listAllContacts() {
		List<ContactsModel> models = new ArrayList<ContactsModel>();
		List<ContactsEntity> entities = contactsRepository.findAll();
		for (ContactsEntity entity : entities) {
			models.add(contactsConverter.convertToModel(entity));
		}
		return models;
	}

	@Override
	public ContactsEntity findContactById(int id) {
		return contactsRepository.findById(id);
	}
	
	@Override
	public ContactsModel findContactByIdModel(int id) {
		return contactsConverter.convertToModel(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		ContactsEntity entity = findContactById(id);
		if(entity != null) {
			contactsRepository.delete(entity);
		}
	}
}
