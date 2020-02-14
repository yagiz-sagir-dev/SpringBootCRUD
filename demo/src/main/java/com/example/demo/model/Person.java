package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "people")
public class Person {
	
	@Id
	private UUID id;
	
	@NotBlank
	@Column(name = "name")
	private String name;
	
	public Person() {}
	
	public Person(UUID id, @JsonProperty("name") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
