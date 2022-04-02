package model.dao;

import model.entities.Trabalhador;
import model.entities.Trilha;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class TrilhaRepository {

    private EntityManager entityManager;

    public TrilhaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Trilha trilha) {
        this.entityManager.persist(trilha);
    }

    public void delete(Trilha trilha) {
        this.entityManager.remove(convertToMerge(trilha));
    }

    public Trilha getById(Long id) {
        return this.entityManager.find(Trilha.class, id);
    }

    public Trilha update(Trilha trilha) {
        return convertToMerge(trilha);
    }

    public Optional<Trilha> findByName(String nome) {
        String sql = "SELECT * FROM Trilha WHERE nome =:nome";
        return (Optional<Trilha>) this.entityManager.createNativeQuery(sql, Trabalhador.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Trilha> listAll() {
        String sql = "SELECT * FROM Trilha";
        return this.entityManager.createNativeQuery(sql, Trilha.class)
                .getResultList();
    }

    private Trilha convertToMerge(Trilha trilha) {
        return this.entityManager.merge(trilha);
    }
}
