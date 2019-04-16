package services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SkillService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();
}
