package br.com.techdive.ferias.projeto1.service;

import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public interface CriarFuncionario {

    Funcionario criarFuncionario(FuncionarioRequest funcionarioRequest);
}
