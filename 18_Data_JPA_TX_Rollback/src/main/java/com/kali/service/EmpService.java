package com.kali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kali.entity.Address;
import com.kali.entity.Emp;
import com.kali.repo.AddrRepo;
import com.kali.repo.EmpRepo;

import jakarta.transaction.Transactional;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private AddrRepo addrRepo;

	@Transactional(rollbackOn = Exception.class)
	public void saveEmp() {
		
		Emp e=new Emp();
		e.setName("chary");
		e.setSalary(3000.00);
		Emp savedEmp = empRepo.save(e); //saving emp
		
		int i=10/0;
		
		Address addr=new Address();
		addr.setCity("Pune");
		addr.setState("MH");
		addr.setCountry("India");
		
		addr.setEid(savedEmp.getEid());
		addrRepo.save(addr); //saving addr
		
		
	}
}
