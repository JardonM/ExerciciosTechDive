package model.dao;

import model.entities.HistoricoFuncao;

import javax.persistence.EntityManager;

public class HistoricoFuncaoRepository {

    private final EntityManager entityManager;

    public HistoricoFuncaoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public HistoricoFuncao save(HistoricoFuncao historicoFuncao) {
        return entityManager.merge(historicoFuncao);
    }

    public HistoricoFuncao findById(Long id) {
        return entityManager.find(HistoricoFuncao.class, id);
    }

    public void delete(HistoricoFuncao historicoFuncao) {
        entityManager.remove(historicoFuncao);
    }

}
