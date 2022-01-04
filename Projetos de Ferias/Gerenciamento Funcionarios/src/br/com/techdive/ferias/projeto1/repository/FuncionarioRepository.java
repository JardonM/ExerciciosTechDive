package br.com.techdive.ferias.projeto1.repository;

import br.com.techdive.ferias.projeto1.domain.Funcionario;

import java.util.ArrayList;
import java.util.List;

public interface FuncionarioRepository {
    List<Funcionario> todosFuncionarios = new ArrayList<>();
    List<Funcionario> funcionariosAtivos = new ArrayList<>();
    List<Funcionario> funcionariosDemitidos = new ArrayList<>();

}
