package com.kbaez.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kbaez.repository.IPerson;

public class PersonRepository implements IPerson {

	private static Logger LOG = LoggerFactory.getLogger(PersonRepository.class);
	@Override
	public void add(String name) {
		LOG.info("SE REGISTRO "+ name);		
	}

}
