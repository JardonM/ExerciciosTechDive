package model.dao;

import model.entities.Funcao;

import javax.persistence.EntityManager;
import java.util.Optional;

public class FuncaoRepository {
    private final EntityManager entityManager;

    public FuncaoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Funcao save(Funcao funcao) {
        return this.entityManager.merge(funcao);
    }

    public Optional<Funcao> findByName(String nomeFuncao) {
        return (Optional<Funcao>) entityManager.createNativeQuery("SELECT f from Funcao f where f.nome = :nomeFuncao", Funcao.class)
                .setParameter("nomeFuncao", nomeFuncao)
                .getSingleResult();
    }
}
