package com.kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kali.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
