package com.kali.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kali.entity.Employee;
import com.kali.repo.EmpRepo;

@Service
public class EmpService {

	private EmpRepo empRepo;
	
	public EmpService(EmpRepo repo) {
		this.empRepo=repo;
	}
	
	public void getAllEmps() {
		List<Employee> emps = empRepo.findAll();
		
		emps.forEach(e-> System.out.println(e));
	}
	
	public void getAllEmpsSort() {
		//Sort sort = Sort.by("esalary").ascending();
		Sort sort = Sort.by("esalary", "ename").descending();
		List<Employee> emps = empRepo.findAll(sort);
		
		emps.forEach(e-> System.out.println(e));
	}
	
	public void getAllEmpsPagination() {
		
		int pageSize = 3; //fixed value
		int pageNumber = 0; //will come from UI
		
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		
		Page<Employee> page = empRepo.findAll(pageRequest);
		List<Employee> emps = page.getContent();
		
		emps.forEach(e-> System.out.println(e));
	}
	
	public void getAllEmpsWithFilter() {
		
		Employee entity=new Employee();
		entity.setEname("Ram"); //if emp name comes from ui
		entity.setEsalary(1000.00); //if salary comes from ui
		
		Example<Employee> example = Example.of(entity); 
		
		List<Employee> emps = empRepo.findAll(example);
		emps.forEach(e-> System.out.println(e));
	}
}
