package com.kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kali.entity.Address;

public interface AddrRepo extends JpaRepository<Address, Integer>{

}
