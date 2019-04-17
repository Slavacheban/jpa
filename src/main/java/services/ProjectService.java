package services;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ProjectService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();

    public void add(Project project){
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Project get(long id){
        return em.find(Project.class, id);
    }

    public void update(Project project){
        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
    }
}
