package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.beans.Person;
import com.dev.service.PersonServices;

@Controller
public class AddPersonContorller {
	
	@Autowired
	PersonServices services;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPage(ModelAndView mv) {
		mv.setViewName("addPerson");
		return mv;
	}
	
	@RequestMapping(value="/addPerson", method=RequestMethod.POST)
	public ModelAndView addPerson(Person person, ModelAndView mv) {
		mv.setViewName("msg");
		boolean state = services.addPerson(person);
		String msg = "Failed to add Person Data";
		if(state) {
			msg = "Person Data added";
		}
		mv.addObject("msg",msg);
		return mv;
	}
}
