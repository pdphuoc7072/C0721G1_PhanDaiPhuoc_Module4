package com.codegym.repository.impl;

import com.codegym.model.ImageOfTheDay;
import com.codegym.repository.IImageOfTheDayRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ImageOfTheDayRepositoryImpl implements IImageOfTheDayRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ImageOfTheDay> findAll() {
        String queryString = "SELECT i from ImageOfTheDay AS i";
        TypedQuery<ImageOfTheDay> query = entityManager.createQuery(queryString, ImageOfTheDay.class);
        return query.getResultList();
    }

    @Override
    public void saveOrUpdate(ImageOfTheDay imageOfTheDay) {
        if (imageOfTheDay.getId() != null) {
            entityManager.merge(imageOfTheDay);
        } else {
            entityManager.persist(imageOfTheDay);
        }
    }

    @Override
    public ImageOfTheDay like(Long id) {
        ImageOfTheDay originImageOfTheDay = findById(id);
        originImageOfTheDay.setLikeCount(originImageOfTheDay.getLikeCount()+1);
        entityManager.merge(originImageOfTheDay);
        return originImageOfTheDay;
    }

    @Override
    public ImageOfTheDay findById(Long id) {
        String queryString = "SELECT i FROM ImageOfTheDay AS i WHERE i.id = :id";
        TypedQuery<ImageOfTheDay> query = entityManager.createQuery(queryString, ImageOfTheDay.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
