package com.kali.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kali.entity.Employee;
import com.kali.repo.EmpRepository;

@Service
public class EmpService {
	
	private EmpRepository empRepo;

	public EmpService(EmpRepository empRepo) {
		this.empRepo= empRepo;
	}
	
	public void saveEmployee() {
		System.out.println("Impl class : "+empRepo.getClass().getName());
		
		//creating entity obj
		Employee e=new Employee();
		e.setEid(103);
		e.setEname("Charles");
		e.setEsalary(6000.30);
		
		//inserting record based on given obj
		empRepo.save(e);
		
		System.out.println("Record saved....");
	}
	
	public void saveEmps() { //saving multiple employees
		
		Employee e1=new Employee(201, "Ram", 1000.00);
		Employee e2=new Employee(202, "Anil", 2000.00);
		Employee e3=new Employee(203, "Sunil", 3000.00);
		
		List<Employee> emps = Arrays.asList(e1, e2, e3);
		empRepo.saveAll(emps);
		
		System.out.println("Records saved....");
	}
	
	public void getEmp(Integer eid) {
		Optional<Employee> findById = empRepo.findById(eid);
		if(findById.isPresent()) {
			Employee employee = findById.get();
			System.out.println(employee);
		}else {
			System.out.println("Record Not Found...");
		}
	}
	
	public void getEmps(List<Integer> eids) {
		Iterable<Employee> emps = empRepo.findAllById(eids);
		//emps.forEach(e-> System.out.println(e));
		
		emps.forEach(System.out::println);
	}
	
	public void getEmps() {
		Iterable<Employee> emps = empRepo.findAll();
		emps.forEach(e-> System.out.println(e));
	}
	
	public void callFindByMethods() {
		//List<Employee> emps = empRepo.findByEname("Charles");
		List<Employee> emps = empRepo.findByEsalaryGreaterThanEqual(4000.00);
		emps.forEach(System.out::println);
	}
	
	public void callCustomQueries() {
		//List<Employee> empHQL = empRepo.getAllEmpsHQL();
		//empHQL.forEach(System.out::println);
		
		//Employee empId = empRepo.getEmpId(101);
		//System.out.println(empId);
		
		List<Employee> allEmpsSQL = empRepo.getAllEmpsSQL();
		allEmpsSQL.forEach(System.out::println);
	}
}
