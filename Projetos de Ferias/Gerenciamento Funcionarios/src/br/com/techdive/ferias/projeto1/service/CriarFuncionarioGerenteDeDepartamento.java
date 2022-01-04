package br.com.techdive.ferias.projeto1.service;


import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.domain.GerenteDeDepartamento;
import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;
import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class CriarFuncionarioGerenteDeDepartamento implements CriarFuncionario{
    @Override
    public Funcionario criarFuncionario(FuncionarioRequest funcionarioRequest) {
        GerenteDeDepartamento novoGerenteDeDepartamento = new GerenteDeDepartamento(funcionarioRequest);
        FuncionarioRepository.funcionariosAtivos.add(novoGerenteDeDepartamento);
        return novoGerenteDeDepartamento;
    }
}
