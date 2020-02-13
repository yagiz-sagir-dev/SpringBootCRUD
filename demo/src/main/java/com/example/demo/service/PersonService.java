package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {
	
	private final PersonDao personDao;

	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	public int AddPerson(Person person) {
		UUID id=UUID.randomUUID();
		return personDao.InsertPerson(id, person);
	}
	
	public List<Person> GetAllPeople(){
		return personDao.GetAllPeople();
	}
	
	public Optional<Person> GetPersonById(UUID id){
		return personDao.GetPersonById(id);
	}
	
	public int DeletePerson(UUID id) {
		return personDao.DeletePersonById(id);
	}
	
	public int UpdatePerson(UUID id, Person newPerson) {
		return personDao.UpdatePersonById(id, newPerson);
	}
}
