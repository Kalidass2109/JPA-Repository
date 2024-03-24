package com.kali.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kali.entity.Passport;
import com.kali.entity.Person;
import com.kali.repo.PassportRepo;
import com.kali.repo.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private PassportRepo passportRepo;
	
	public void getPassport() {
		passportRepo.findById(1);
	}
	
	public void getPerson() {
		personRepo.findById(1); //here one to one is eager loading, so child also 
														//will be retrieved along with parent
	}
	
	public void savePerson() {
		
		Person p=new Person();
		p.setName("John");
		p.setGender("male");
		
		Passport pp=new Passport();
		pp.setPassportNum("JIG9976K");
		pp.setIssuedDate(LocalDate.now());
		pp.setExpDate(LocalDate.now().plusYears(10));
		
		//associating person with passport
		p.setPassport(pp);
		//associating passport with person
		pp.setPerson(p);
		
		//saving person record (parent), when saving parent, child also will be saved along with that, no need to call separate call for child
		personRepo.save(p);
		
		System.out.println("Record inserted...");
	}

}
