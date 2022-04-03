package model.dao;

import lombok.NoArgsConstructor;
import model.entities.Trabalhador;

import javax.persistence.EntityManager;
import java.util.Optional;

@NoArgsConstructor
public class TrabalhadorRepository {

    private EntityManager entityManager;

    public TrabalhadorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Trabalhador trabalhador) {
        this.entityManager.persist(trabalhador);
    }

    public void delete(Trabalhador trabalhador) {
        this.entityManager.remove(convertToMerge(trabalhador));
    }

    public Trabalhador getById(Long id) {
        return this.entityManager.find(Trabalhador.class, id);
    }

    public Trabalhador update(Trabalhador trabalhador) {
        return convertToMerge(trabalhador);
    }

    public Optional<Trabalhador> findByCpf(String cpf) {
        String sql = "SELECT t FROM Trabalhador t WHERE t.cpf =:cpf";
        return (Optional<Trabalhador>) this.entityManager.createNativeQuery(sql, Trabalhador.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }

    private Trabalhador convertToMerge(Trabalhador trabalhador) {
        return this.entityManager.merge(trabalhador);
    }
}
