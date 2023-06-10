package com.nltu.service;

import com.nltu.dao.UserDAO;
import com.nltu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailService implements UserDetailsService {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserDetailService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userService.getUsername(s);
//        if (user == null)
//            throw new UsernameNotFoundException("User not found");
//        return new com.nltu.security.UserDetails(user);
//    }
//}
