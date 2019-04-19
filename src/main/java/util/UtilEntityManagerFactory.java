package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilEntityManagerFactory {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MATE-ACADEMY");
}
