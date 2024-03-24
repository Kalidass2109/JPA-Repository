package com.kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kali.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer>{

}
