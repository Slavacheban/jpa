package services;

import entities.Customer;
import entities.EntityTable;
import util.UtilEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CustomerRepository implements Repository{
    public EntityManager em = UtilEntityManagerFactory.entityManagerFactory.createEntityManager();

    @Override
    public void add(EntityTable customer){
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    @Override
    public Customer get(long id){
        return em.find(Customer.class, id);
    }

    @Override
    public void update(EntityTable customer){
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }
}
