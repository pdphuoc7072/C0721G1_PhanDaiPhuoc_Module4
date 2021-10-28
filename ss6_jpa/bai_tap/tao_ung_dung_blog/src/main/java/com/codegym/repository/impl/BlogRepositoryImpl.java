package com.codegym.repository.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        String queryString = "SELECT b FROM Blog b";
        TypedQuery<Blog> query = entityManager.createQuery(queryString, Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        String queryString = "SELECT b FROM Blog b WHERE b.id = :id";
        TypedQuery<Blog> query = entityManager.createQuery(queryString, Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void saveOrUpdate(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void delete(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }
}
