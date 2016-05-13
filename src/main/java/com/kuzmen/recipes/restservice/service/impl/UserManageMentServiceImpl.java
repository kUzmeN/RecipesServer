package com.kuzmen.recipes.restservice.service.impl;


import com.kuzmen.recipes.restservice.entity.User;
import com.kuzmen.recipes.restservice.repository.UserRepository;
import com.kuzmen.recipes.restservice.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {
    private final static Logger logger = LoggerFactory.getLogger(UserManagementServiceImpl.class);
    @Autowired
    UserRepository userRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        logger.debug("Finding user by email: {}", email);

        try {
            User foundUser = entityManager.createQuery("SELECT u FROM User  u where u.email LIKE :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return foundUser;
        } catch (NoResultException ex) {
            logger.debug("Such user was not found. The NoResultException has been catched");
            return null;
        }
    }
}
