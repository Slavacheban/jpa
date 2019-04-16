package services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DeveloperService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();
}
