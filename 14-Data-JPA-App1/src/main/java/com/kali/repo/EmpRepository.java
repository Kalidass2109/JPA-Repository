package com.kali.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kali.entity.Employee;

//@Repository
public interface EmpRepository extends CrudRepository<Employee, Integer>{

	//select * from employee where ename=:ename
	public List<Employee> findByEname(String ename);
	
	//select * from employee where esalary=:salary
	public List<Employee> findByEsalary(Double salary);
	
	//select * from employee where esalary>=:esalary
	public List<Employee> findByEsalaryGreaterThanEqual(Double salary);
	
	@Query("from Employee") //Employee is class name
	public List<Employee> getAllEmpsHQL();
	
	@Query("from Employee where eid=:id") //:eid is positional parameter
	public Employee getEmpId(Integer id);
	
	@Query(value="select * from employee", nativeQuery = true) //employee is table name, nativeQuery to indicate sql query
	public List<Employee> getAllEmpsSQL();                     //so, JPA will consider this is plain sql query, so no need 
	  														  //of dialect class, no need of conversion, directly it will execute
														     //in DB
}
