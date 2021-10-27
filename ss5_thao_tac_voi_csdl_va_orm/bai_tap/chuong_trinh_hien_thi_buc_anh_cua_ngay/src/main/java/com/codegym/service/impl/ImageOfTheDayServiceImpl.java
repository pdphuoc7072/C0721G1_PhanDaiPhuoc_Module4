package com.codegym.service.impl;

import com.codegym.model.ImageOfTheDay;
import com.codegym.service.ImageOfTheDayService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ImageOfTheDayServiceImpl implements ImageOfTheDayService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
//            sessionFactory.close();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<ImageOfTheDay> findAll() {
        String queryString = "SELECT i from ImageOfTheDay AS i";
        TypedQuery<ImageOfTheDay> query = entityManager.createQuery(queryString, ImageOfTheDay.class);
        return query.getResultList();
    }

    @Override
    public void save(ImageOfTheDay imageOfTheDay) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            imageOfTheDay.setLikeCount(0);
            session.saveOrUpdate(imageOfTheDay);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ImageOfTheDay update(ImageOfTheDay imageOfTheDay) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ImageOfTheDay originImageOfTheDay = findById(imageOfTheDay.getId());
            originImageOfTheDay.setRating(imageOfTheDay.getRating());
            originImageOfTheDay.setAuthor(imageOfTheDay.getAuthor());
            originImageOfTheDay.setMessage(imageOfTheDay.getMessage());
            session.saveOrUpdate(originImageOfTheDay);
            transaction.commit();
            return originImageOfTheDay;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public ImageOfTheDay like(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ImageOfTheDay originImageOfTheDay = findById(id);
            originImageOfTheDay.setLikeCount(originImageOfTheDay.getLikeCount()+1);
            session.saveOrUpdate(originImageOfTheDay);
            transaction.commit();
            return originImageOfTheDay;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public ImageOfTheDay findById(Long id) {
        String queryString = "SELECT i FROM ImageOfTheDay AS i WHERE i.id = :id";
        TypedQuery<ImageOfTheDay> query = entityManager.createQuery(queryString, ImageOfTheDay.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
