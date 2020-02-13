package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

	private static List<Person> DB = new ArrayList<Person>();
	@Override
	public int InsertPerson(UUID id, Person person) {
		DB.add(new Person(id,person.getName()));
		return 1;
	}
	
	@Override
	public List<Person> GetAllPeople() {
		return DB;
	}

	@Override
	public int DeletePersonById(UUID id) {
		Optional<Person> personMaybe = GetPersonById(id);
		if(personMaybe.isEmpty())
			return 0;
		DB.remove(personMaybe.get());
		return 1;
	}

	@Override
	public int UpdatePersonById(UUID id, Person person) {
		return GetPersonById(id)
				.map(p->{
					int indexOfPersonToUpdate = DB.indexOf(p);
					if(indexOfPersonToUpdate >=0) {
						DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}

	@Override
	public Optional<Person> GetPersonById(UUID id) {
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}

	
}
