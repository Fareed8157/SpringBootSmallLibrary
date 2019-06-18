package com.abcl.libmgmt.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abcl.libmgmt.repository.UserRepository;

@Service
public class UserService implements IUserService , UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	public User findUserByName(String userName) {
		com.abcl.libmgmt.model.User userFromDb=userRepository.findByUsername(userName);
		if(userFromDb==null) {
			throw new UsernameNotFoundException("Invalid Username or Password"); 
		}
		
        return new User(userName, userFromDb.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
    }

	@Override
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return findUserByName(username);
	}
}
