package services;

import entities.Developer;
import entities.EntityTable;
import util.UtilEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DeveloperRepository implements Repository {
    public EntityManager em = UtilEntityManagerFactory.entityManagerFactory.createEntityManager();

    @Override
    public void add(EntityTable developer){
        em.getTransaction().begin();
        em.persist(developer);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    @Override
    public Developer get(long id){
        return em.find(Developer.class, id);
    }

    @Override
    public void update(EntityTable developer){
        em.getTransaction().begin();
        em.merge(developer);
        em.getTransaction().commit();
    }
}
