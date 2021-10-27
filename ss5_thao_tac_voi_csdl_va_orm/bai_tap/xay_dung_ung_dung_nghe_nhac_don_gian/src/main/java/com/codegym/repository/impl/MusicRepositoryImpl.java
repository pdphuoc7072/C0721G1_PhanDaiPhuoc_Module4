package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepositoryImpl implements IMusicRepository {
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
    public List<Music> findAll() {
        String queryString = "SELECT m from Music AS m";
        TypedQuery<Music> query = entityManager.createQuery(queryString, Music.class);
        return query.getResultList();
    }

    @Override
    public void save(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(music);
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
    public Music findById(Long id) {
        String queryString = "SELECT m FROM Music AS m WHERE m.id = :id";
        TypedQuery<Music> query = entityManager.createQuery(queryString, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Music update(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music originMusic = findById(music.getId());
            originMusic.setName(music.getName());
            originMusic.setArtist(music.getArtist());
            originMusic.setTypeOfMusic(music.getTypeOfMusic());
            originMusic.setFilePath(music.getFilePath());
            session.saveOrUpdate(originMusic);
            transaction.commit();
            return originMusic;
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
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music music = findById(id);
            if (music != null) {
                session.delete(music);
            }
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
}
