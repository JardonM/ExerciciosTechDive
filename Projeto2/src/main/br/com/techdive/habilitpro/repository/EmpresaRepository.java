package main.br.com.techdive.habilitpro.repository;

import main.br.com.techdive.habilitpro.domain.Empresa;

import java.util.HashMap;

public interface EmpresaRepository {
    HashMap<String, Empresa> empresas = new HashMap<>();
}
