package com.kbaez.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kbaez.repository.IPerson;

@Repository
public class PersonRepository implements IPerson {

	private static Logger LOG = LoggerFactory.getLogger(PersonRepository.class);
	@Override
	public void add(String name) {
		LOG.info("SE REGISTRO "+ name);		
	}

}
