package services;

import entities.Company;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CompanyService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();

    public void add(Company company){
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Company get(long id){
        return em.find(Company.class, id);
    }

    public void update(Company skill){
        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();
    }
}
