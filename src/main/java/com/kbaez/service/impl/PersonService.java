package com.kbaez.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbaez.repository.IPerson;
import com.kbaez.service.IPersonService;

@Service
public class PersonService {
	//trae una instancia definida o definicion de bean
	@Autowired
	private IPerson repository;

}
