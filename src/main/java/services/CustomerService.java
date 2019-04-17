package services;

import entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CustomerService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();

    public void add(Customer customer){
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Customer get(long id){
        return em.find(Customer.class, id);
    }

    public void update(Customer customer){
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }
}
