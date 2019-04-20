package services;

import entities.Company;
import entities.EntityTable;
import util.UtilEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CompanyRepository implements Repository{
    public EntityManager em = UtilEntityManagerFactory.entityManagerFactory.createEntityManager();

    @Override
    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    @Override
    public Company get(long id){
        return em.find(Company.class, id);
    }

    @Override
    public void add(EntityTable entityTable) {
        em.getTransaction().begin();
        em.persist(entityTable);
        em.getTransaction().commit();
    }

    @Override
    public void update(EntityTable entityTable) {
        em.getTransaction().begin();
        em.merge(entityTable);
        em.getTransaction().commit();
    }
}
