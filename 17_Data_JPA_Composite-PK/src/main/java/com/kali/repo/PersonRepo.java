package com.kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kali.entity.Person;
import com.kali.entity.PersonPK;

public interface PersonRepo extends JpaRepository<Person, PersonPK>{

}
