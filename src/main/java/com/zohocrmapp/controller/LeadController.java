package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contacts;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.services.ContactService;
import com.zohocrmapp.services.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/view")
	public String viewLeadPage() {
		return"create_new_lead";
	}
	@PostMapping("/post")
	public String saveLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
	@PostMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, Model model) {
		Lead lead=leadService.findLeadById(id);
		Contacts contact=new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveContact(contact);
		leadService.deleteLeadById(id);
		
		List<Contacts> cont=contactService.listAllContacts();
		model.addAttribute("contact", cont);
		return "list_contact";
	}
	
	@RequestMapping("/listAll")
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id")long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
		
		
	}
}
