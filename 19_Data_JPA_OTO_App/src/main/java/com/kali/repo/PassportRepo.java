package com.kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kali.entity.Passport;

public interface PassportRepo extends JpaRepository<Passport, Integer>{

}
