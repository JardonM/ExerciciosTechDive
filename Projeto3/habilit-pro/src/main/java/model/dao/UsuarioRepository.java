package model.dao;

import model.entities.Usuario;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UsuarioRepository {

    private EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Usuario usuario) {
        this.entityManager.persist(usuario);
    }

    public void delete(Usuario usuario) {
        this.entityManager.remove(convertToMerge(usuario));
    }

    public Usuario getById(Long id) {
        return this.entityManager.find(Usuario.class, id);
    }

    public Usuario update(Usuario usuario) {
        return convertToMerge(usuario);
    }

    public Optional<Usuario> findByCpf(String cpf) {
        String sql = "SELECT * FROM Usuario WHERE cpf =:cpf";
        return (Optional<Usuario>) this.entityManager.createNativeQuery(sql, Usuario.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }

    private Usuario convertToMerge(Usuario usuario) {
        return this.entityManager.merge(usuario);
    }
}
