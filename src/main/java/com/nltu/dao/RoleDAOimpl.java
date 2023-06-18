package com.nltu.dao;

import com.nltu.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOimpl implements RoleDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Role getRoleByName(String roleName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Role> query = currentSession.createQuery("FROM Role WHERE roleName = :roleName", Role.class);
        query.setParameter("roleName", "ROLE_USER");
        List <Role> roles = query.getResultList();
        if (!roles.isEmpty()) {
            return roles.get(0);
        } else {
            return null;
        }
    }
}
