package com.nltu.service;

import com.nltu.dao.RoleDAO;
import com.nltu.dao.UserDAO;
import com.nltu.entity.Role;
import com.nltu.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(User user){
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    Role role = roleDAO.getRoleByName("ROLE_USER");
    if (role == null) {
        role = new Role();
        role.setRoleName("ROLE_USER");
    }
    user.setPassword(encodedPassword);
    user.setRole(role);
    userDAO.save(user);
    }

}
