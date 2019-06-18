package com.abcl.libmgmt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcl.libmgmt.model.User;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	 @Query("select u from User u where username = :userName")
	 public User findByUsername(@Param("userName") String userName);
} 
