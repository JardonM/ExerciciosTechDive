package model.dao;

import model.entities.Empresa;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class EmpresaRepository {

    private final EntityManager entityManager;

    public EmpresaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Empresa empresa) {
        this.entityManager.persist(empresa);
    }

    public void delete(Empresa empresa) {
        this.entityManager.remove(convertToMerge(empresa));
    }

    public Empresa getById(Long id) {
        return this.entityManager.find(Empresa.class, id);
    }

    public Empresa update(Empresa empresa) {
        return convertToMerge(empresa);
    }

    public Optional<Empresa> findByCnpj(String cnpj) {
        String sql = "SELECT Empresa FROM Empresa WHERE cnpj = :cnpj";
        return Optional.ofNullable(this.entityManager.createQuery(sql, Empresa.class)
                .setParameter("cnpj", cnpj)
                .getSingleResult());
    }

    public boolean existsByCnpj(String cnpj) {
        String sql = "SELECT count(Empresa) FROM Empresa WHERE cnpj = :cnpj";
        return this.entityManager.createQuery(sql, Long.class)
                .setParameter("cnpj", cnpj)
                .getSingleResult() > 0;
    }

    public List<Empresa> findAll() {
        return this.entityManager.createQuery("select Empresa from Empresa", Empresa.class).getResultList();
    }

    private Empresa convertToMerge(Empresa empresa) {
        return this.entityManager.merge(empresa);
    }
}
