package com.kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kali.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
