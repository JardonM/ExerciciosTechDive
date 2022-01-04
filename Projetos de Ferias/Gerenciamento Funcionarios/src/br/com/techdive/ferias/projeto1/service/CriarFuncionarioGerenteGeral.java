package br.com.techdive.ferias.projeto1.service;


import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.domain.GerenteGeral;
import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;
import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class CriarFuncionarioGerenteGeral implements CriarFuncionario{
    @Override
    public Funcionario criarFuncionario(FuncionarioRequest funcionarioRequest) {
        GerenteGeral novoGerenteGeral = new GerenteGeral(funcionarioRequest);
        FuncionarioRepository.funcionariosAtivos.add(novoGerenteGeral);
        return novoGerenteGeral;
    }
}
