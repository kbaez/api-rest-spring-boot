package com.kbaez.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbaez.repository.IPerson;
import com.kbaez.service.IPersonService;

@Service
public class PersonService implements IPersonService{
	//trae una instancia definida o definicion de bean
	@Autowired
	private IPerson repository;

	@Override
	public void addPerson(String name) {
		// TODO Auto-generated method stub
		repository.add(name);
	}

}
