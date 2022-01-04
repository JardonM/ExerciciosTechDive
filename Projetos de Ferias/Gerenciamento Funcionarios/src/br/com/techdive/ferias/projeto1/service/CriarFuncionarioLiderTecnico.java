package br.com.techdive.ferias.projeto1.service;

import br.com.techdive.ferias.projeto1.domain.Colaborador;
import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.domain.LiderTecnico;
import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;
import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;

public class CriarFuncionarioLiderTecnico implements CriarFuncionario{
    @Override
    public Funcionario criarFuncionario(FuncionarioRequest funcionarioRequest) {
        LiderTecnico novoLiderTecnico = new LiderTecnico(funcionarioRequest);
        FuncionarioRepository.funcionariosAtivos.add(novoLiderTecnico);
        return novoLiderTecnico;
    }
}
