package br.com.techdive.ferias.projeto1.service;

import br.com.techdive.ferias.projeto1.domain.Colaborador;
import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;
import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class CriarFuncionarioColaborador implements CriarFuncionario{

    @Override
    public Funcionario criarFuncionario(FuncionarioRequest funcionarioRequest) {
        Colaborador novoColaborador = new Colaborador(funcionarioRequest);
        FuncionarioRepository.funcionariosAtivos.add(novoColaborador);
        return novoColaborador;
    }
}
