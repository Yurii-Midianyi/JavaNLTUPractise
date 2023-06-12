package com.nltu.service;

import com.nltu.dao.UserDAO;
import com.nltu.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserDAO userDAO;
    @Autowired
    public UserDetailService( UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userDAO.getUsername(s);
		if (user == null)
			throw new UsernameNotFoundException("User not found");
		return new com.nltu.security.UserDetails(user);
	}
}
