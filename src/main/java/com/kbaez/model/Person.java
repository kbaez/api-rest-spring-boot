package com.kbaez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Person {
	@Id
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private String age;
}
