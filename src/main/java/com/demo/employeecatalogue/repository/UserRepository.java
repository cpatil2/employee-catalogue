package com.demo.employeecatalogue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.employeecatalogue.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	Optional<UserDetails> findByMobile(String mobile);
	
}
