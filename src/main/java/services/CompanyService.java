package services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CompanyService {
    public EntityManager em = Persistence.createEntityManagerFactory("MATE-ACADEMY")
            .createEntityManager();
}
