package model.dao;

import model.entities.Empresa;
import model.entities.Modulo;

import javax.persistence.EntityManager;

public class ModuloRepository {

    private EntityManager entityManager;

    public ModuloRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Modulo modulo) {
        this.entityManager.persist(modulo);
    }

    public void delete(Modulo modulo) {
        this.entityManager.remove(convertToMerge(modulo));
    }

    public Modulo getById(Long id) {
        return this.entityManager.find(Modulo.class, id);
    }

    public Modulo update(Modulo modulo) {
        return convertToMerge(modulo);
    }

    private Modulo convertToMerge(Modulo modulo) {
        return this.entityManager.merge(modulo);
    }
}
