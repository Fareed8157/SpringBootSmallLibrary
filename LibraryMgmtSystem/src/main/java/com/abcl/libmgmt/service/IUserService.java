package com.abcl.libmgmt.service;

import org.springframework.security.core.userdetails.User;

public interface IUserService {

	public default User findUserByName(String userName) {
        return null;
    }
}
