package br.com.techdive.ferias.projeto1.service;

import br.com.techdive.ferias.projeto1.domain.*;
import br.com.techdive.ferias.projeto1.repository.EquipeRepository;
import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;

public class PopularListasFuncionarios {

    public static void popularListas() {
        for(int i = 1; i < 5; i++) {

            Colaborador colaboradorTeste = new Colaborador("Colaborador", "Teste" + i, "0010000000" + i, 1200 + 50 * i);
            GerenteDeDepartamento gerenteDeDepartamentoTeste = new GerenteDeDepartamento("Gerente", "Departamento Teste" + i, "0050000000" + i, 3000 + 50 * i);
            GerenteGeral gerenteGeralTeste = new GerenteGeral("Gerente", "Geral Teste" + i, "0066000000" + i, 5000 + 50 * i);
            LiderTecnico liderTecnicoTeste = new LiderTecnico("Lider", "Teste" + i, "0022000000" + i, 3500 + 50 * i);
            Equipe equipe = new Equipe("Equipe" + i);

            FuncionarioRepository.funcionariosAtivos.add(colaboradorTeste);
            FuncionarioRepository.todosFuncionarios.add(colaboradorTeste);
            FuncionarioRepository.funcionariosAtivos.add(gerenteDeDepartamentoTeste);
            FuncionarioRepository.todosFuncionarios.add(gerenteDeDepartamentoTeste);
            FuncionarioRepository.funcionariosAtivos.add(gerenteGeralTeste);
            FuncionarioRepository.todosFuncionarios.add(gerenteGeralTeste);
            FuncionarioRepository.funcionariosAtivos.add(liderTecnicoTeste);
            FuncionarioRepository.todosFuncionarios.add(liderTecnicoTeste);
            EquipeRepository.equipes.add(equipe);
        }

    }
}
