package services;

import entities.Developer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DeveloperService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();

    public void add(Developer developer){
        em.getTransaction().begin();
        em.persist(developer);
        em.getTransaction().commit();
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Developer get(long id){
        return em.find(Developer.class, id);
    }

    public void update(Developer developer){
        em.getTransaction().begin();
        em.merge(developer);
        em.getTransaction().commit();
    }
}
