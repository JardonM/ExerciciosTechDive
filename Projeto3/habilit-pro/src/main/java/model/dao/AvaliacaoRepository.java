package model.dao;

import model.entities.Avaliacao;

import javax.persistence.EntityManager;

public class AvaliacaoRepository {

    private final EntityManager entityManager;

    public AvaliacaoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Avaliacao save(Avaliacao avaliacao) {
        return entityManager.merge(avaliacao);
    }

}
