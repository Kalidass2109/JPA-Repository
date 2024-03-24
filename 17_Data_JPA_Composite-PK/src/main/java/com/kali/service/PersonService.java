package com.kali.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kali.entity.Person;
import com.kali.entity.PersonPK;
import com.kali.repo.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo personRepo;
	
	public void savePerson() {
		PersonPK pks=new PersonPK();
		pks.setPersonId(101);
		pks.setPassportNum("JIGPK231U");
		
		Person p=new Person();
		p.setName("Nirallan");
		p.setGender("Male");
		p.setEmail("nirallan@gmail.com");
		
		p.setPersonPK(pks); //setting primary keys
		
		personRepo.save(p);
		
		System.out.println("Person saved....");
	}
	
	public void getPerson() {
		PersonPK pks=new PersonPK();
		pks.setPersonId(101);
		pks.setPassportNum("JIGPK231U");
		
		Optional<Person> findById = personRepo.findById(pks);
		
		if(findById.isPresent()) {
			Person person = findById.get();
			System.out.println(person);
		}
	}

}
