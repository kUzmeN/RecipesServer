package com.kuzmen.recipes.restservice.service.impl;


import com.kuzmen.recipes.restservice.entity.Comment;
import com.kuzmen.recipes.restservice.entity.Recipe;
import com.kuzmen.recipes.restservice.entity.User;
import com.kuzmen.recipes.restservice.repository.CommentRepository;
import com.kuzmen.recipes.restservice.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Repository
@Transactional
@ComponentScan("com.kuzmen.recipes.restservice.util")
public class CommentServiceImpl implements CommentService {
    private final static Logger logger = LoggerFactory.getLogger(UserManagementServiceImpl.class);
    @Autowired
    CommentRepository commentRepository;


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

//    @Override
//    public List<Comment> findByRecipe(int id) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Comment> query = cb.createQuery(Comment.class);
//        Root<Comment> entity = query.from(Comment.class);
//        Predicate where = cb.equal(entity
//        query.where(whereClause);
//        return entityManager.createQuery(query).getResultList();
//    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findByRecipe(int recipeId) {
        try {
            List<Comment> comments = entityManager.createQuery("SELECT u FROM Comment  u where u.recipe.id LIKE :recipeId", Comment.class)
                    .setParameter("recipeId", recipeId)
                    .getResultList();
            return comments;
        } catch (NoResultException ex) {
            logger.debug("Such user was not found. The NoResultException has been catched");
            return null;
        }

    }

}
