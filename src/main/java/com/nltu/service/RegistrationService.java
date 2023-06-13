package com.nltu.service;

import com.nltu.dao.UserDAO;
import com.nltu.entity.Role;
import com.nltu.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        Role role = new Role();
        user.setPassword(encodedPassword);
        role.setRoleName("ROLE_USER");
        user.setRole(role);
        userDAO.save(user);
    }
}
