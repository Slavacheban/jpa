package services;

import entities.Skill;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Log4j
public class SkillService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();

    public void add(Skill skill){
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Skill get(long id){
        return em.find(Skill.class, id);
    }

    public void update(Skill skill){
        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();
    }
}
