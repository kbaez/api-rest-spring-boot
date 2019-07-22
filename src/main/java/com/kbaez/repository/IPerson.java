package com.kbaez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kbaez.model.Person;

@Repository
public interface IPerson extends JpaRepository<Person, Integer>{
	
}
