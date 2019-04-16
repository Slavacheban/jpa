package services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ProjectService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();
}
