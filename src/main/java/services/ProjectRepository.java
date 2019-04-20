package services;

import entities.EntityTable;
import entities.Project;
import util.UtilEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ProjectRepository implements Repository{
    public EntityManager em = UtilEntityManagerFactory.entityManagerFactory.createEntityManager();

    @Override
    public void add(EntityTable project){
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    @Override
    public Project get(long id){
        return em.find(Project.class, id);
    }

    @Override
    public void update(EntityTable project){
        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
    }
}
