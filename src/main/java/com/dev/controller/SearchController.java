package com.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dev.beans.Person;
import com.dev.service.PersonServices;

@Controller
public class SearchController {
	
	@Autowired
	PersonServices services;
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public ModelAndView searchPage(ModelAndView mv) {
		mv.setViewName("search");
		return mv;
	}
	
	@RequestMapping(value="searchByName", method=RequestMethod.GET)
	public ModelAndView searchByName(ModelAndView mv, 
										@RequestParam("name") String name) {
		mv.setViewName("msg");
		List<Person> list = services.searchByName(name);
		mv.addObject("msg", list);
		return mv;
	}
}
