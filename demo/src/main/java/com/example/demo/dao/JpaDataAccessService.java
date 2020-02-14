package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Repository("jpa")
public class JpaDataAccessService implements PersonDao{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public int InsertPerson(UUID id, Person person) {
		personRepository.save(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> GetAllPeople() {
		return personRepository.findAll();
	}

	@Override
	public int DeletePersonById(UUID id) {
		Optional<Person> personMaybe = GetPersonById(id);
		if(personMaybe.isEmpty())
			return 0;
		personRepository.delete(personMaybe.get());
		return 1;
	}

	@Override
	public int UpdatePersonById(UUID id, Person person) {
		Optional<Person> personMaybe = GetPersonById(id);
		if(personMaybe.isEmpty())
			return 0;
		personRepository.save(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public Optional<Person> GetPersonById(UUID id) {
		return personRepository.findById(id);
	}

	
}
