package com.kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kali.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
