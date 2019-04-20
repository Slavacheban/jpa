package services;

import entities.EntityTable;
import entities.Skill;
import lombok.extern.log4j.Log4j;
import util.UtilEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Log4j
public class SkillRepository implements Repository{
    public EntityManager em = UtilEntityManagerFactory.entityManagerFactory.createEntityManager();

    @Override
    public void add(EntityTable skill){
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    @Override
    public Skill get(long id){
        return em.find(Skill.class, id);
    }

    @Override
    public void update(EntityTable skill){
        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();
    }
}
