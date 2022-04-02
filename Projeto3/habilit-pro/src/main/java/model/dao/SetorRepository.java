package model.dao;

import model.entities.Setor;

import javax.persistence.EntityManager;

public class SetorRepository {

    private final EntityManager entityManager;

    public SetorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Setor findById(Long id) {
        return entityManager.find(Setor.class, id);
    }

    public Setor save(Setor setor) {
        return this.entityManager.merge(setor);
    }

}
