package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {
	
	int InsertPerson(UUID id, Person person);
	
	default int AddPerson(Person person) {
		UUID id = UUID.randomUUID();
		return InsertPerson(id, person);
	}
	
	List<Person> GetAllPeople();
	
	int DeletePersonById(UUID id);
	
	int UpdatePersonById(UUID id, Person person);
	
	Optional<Person> GetPersonById(UUID id);
}
