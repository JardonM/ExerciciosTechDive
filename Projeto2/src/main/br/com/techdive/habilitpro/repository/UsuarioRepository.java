package main.br.com.techdive.habilitpro.repository;

import main.br.com.techdive.habilitpro.domain.Usuario;

import java.util.HashMap;

public interface UsuarioRepository {
    HashMap<String, Usuario> usuarios = new HashMap<>();
}
