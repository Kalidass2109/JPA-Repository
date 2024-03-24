package com.kali.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kali.entity.Address;
import com.kali.entity.Emp;
import com.kali.repo.AddrRepo;
import com.kali.repo.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private AddrRepo addrRepo;
	
	public void getEmp() {
		Optional<Emp> findById = empRepo.findById(5);// only parent if fetch is lazy
		if(findById.isPresent()) {
			Emp emp = findById.get();
			List<Address> addrList = emp.getAddrList();
			System.out.println(addrList);
		}
	}
	
	public void getAddress() {
		addrRepo.findById(1); // child + parent
	}
	
	public void deleteEmp() {
		empRepo.deleteById(5); //first it will delete child records and then parent
	}

	
	public void saveEmployee() {
		
		Emp e=new Emp();
		e.setName("Orlen");
		e.setEsal(12000.00);
		
		Address a1=new Address();
		a1.setCity("Hyd");
		a1.setState("TG");
		a1.setCountry("India");
		a1.setType("Present");
		
		Address a2=new Address();
		a2.setCity("TVM");
		a2.setState("TN");
		a2.setCountry("India");
		a2.setType("Permanent");
		
		//association
		a1.setEmp(e); //setting parent to child
		a2.setEmp(e); //setting parent to child
		
		e.setAddrList(Arrays.asList(a1, a2)); //setting child classes to parent
		
		//save parent record
		empRepo.save(e); //parent + childs
	}

}
