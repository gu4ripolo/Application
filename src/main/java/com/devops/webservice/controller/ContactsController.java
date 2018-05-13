package com.devops.webservice.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.devops.webservice.entity.ContactsEntity;
import com.devops.webservice.model.ContactsModel;
import com.devops.webservice.service.ContactsService;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

	//private static final Log LOG = LogFactory .getLog(ContactsController.class);
	
	@Autowired 
	@Qualifier("contactsServiceImpl")
	private ContactsService contactService; 
	
	@GetMapping("/contactform")
	private String redirectContactForm(@RequestParam(name="id", required=false) int id, Model model) {
		ContactsModel contact = new ContactsModel(); 
		if (id != 0) {
		 contact = contactService.findContactByIdModel(id);
		}
		model.addAttribute("contactModel", contact);
		return "contactform";
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactsModel contact, Model model) {
		if (contactService.addContact(contact) != null) {
			//LOG.info("Method: addContact() -- Paramas: " + contact.getFirstname() + "" + contact.getLastname());
			model.addAttribute("result", 1);			
		} else {
			model.addAttribute("result", 0);	
		}
		return "redirect:/contacts/showcontacts";

	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView("contacts");
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) int id) {
		contactService.removeContact(id);
		return showContacts();
	}
	

}
