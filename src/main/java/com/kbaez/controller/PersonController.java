package com.kbaez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kbaez.model.Person;
import com.kbaez.repository.IPerson;

@EnableJpaRepositories("com.kbaez.repository")
@Controller
public class PersonController {
	
	@Autowired
	private IPerson repository;
	
	 @GetMapping("/persona")
	    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        
		 	Person p = new Person();
		 	p.setId(1);
		 	p.setName("Carolina");
		 	p.setAge("18");
		 	repository.save(p);
		 	model.addAttribute("name", name);
	        return "greeting";
	    }
}
