package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
//maneja el crud
public class EntityManagerAdmin {
    private static EntityManager instance;
    private static final String UNIDAD_PERSISTENCIA = "DEMOPG";

    public static EntityManager getInstance() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory(UNIDAD_PERSISTENCIA);
        instance = emf.createEntityManager();
        return instance;
    }
}
