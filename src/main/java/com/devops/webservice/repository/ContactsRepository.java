package com.devops.webservice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devops.webservice.entity.ContactsEntity;

@Repository("contactsRepository")
public interface ContactsRepository extends JpaRepository<ContactsEntity, Serializable>{
	
	public abstract ContactsEntity findById(int id);
	
}
