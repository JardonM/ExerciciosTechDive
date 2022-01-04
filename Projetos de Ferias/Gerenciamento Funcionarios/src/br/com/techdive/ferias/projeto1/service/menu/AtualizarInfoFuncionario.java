package br.com.techdive.ferias.projeto1.service.menu;

import br.com.techdive.ferias.projeto1.domain.*;
import br.com.techdive.ferias.projeto1.repository.EquipeRepository;
import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;
import br.com.techdive.ferias.projeto1.service.PesquisaFuncionario;
import br.com.techdive.ferias.projeto1.service.Teclado;

public class AtualizarInfoFuncionario {


    public static void atualizarInfoFuncionario() {
        Teclado lerTeclado = new Teclado();
        Funcionario funcionario = PesquisaFuncionario.pesquisaFuncionario();
        System.out.println("Qual informacao deseja atualizar? ");
        System.out.println("1 --- Nome");
        System.out.println("2 --- Sobrenome");
        System.out.println("3 --- Salario");
        System.out.println("4 --- Designar Equipe");
        System.out.println("5 --- Cargo");
        System.out.println("6 --- Voltar");
        int opcaoEscolhida = lerTeclado.lerInteger("Opcao desejada: ");
        switch (opcaoEscolhida) {
            case 1:
                String novoNome = lerTeclado.lerString("Digite o nome para atualizar: ");
                FuncionarioRepository.funcionariosAtivos.remove(funcionario);
                funcionario.setNome(novoNome);
                FuncionarioRepository.funcionariosAtivos.add(funcionario);
                break;
            case 2:
                String novoSobrenome = lerTeclado.lerString("Digite o sobrenome para atualizar: ");
                FuncionarioRepository.funcionariosAtivos.remove(funcionario);
                funcionario.setSobrenome(novoSobrenome);
                FuncionarioRepository.funcionariosAtivos.add(funcionario);
                break;
            case 3:
                double novoSalario = lerTeclado.lerDouble("Digite o salario para atualizar: ");
                FuncionarioRepository.funcionariosAtivos.remove(funcionario);
                funcionario.setSalario(novoSalario);
                FuncionarioRepository.funcionariosAtivos.add(funcionario);
                break;
            case 4:
                if(funcionario.getClass().equals(GerenteGeral.class)) {
                    System.out.println("Gerente Geral não pode ter uma equipe designada.");
                } else {
                    String nomeEquipe = lerTeclado.lerString("Digite o nome da equipe: ");
                    Equipe equipe = EquipeRepository.equipes.stream().filter(e -> e.getNome().equals(nomeEquipe)).findFirst().orElse(null);
                    if(equipe == null) {
                        System.out.println("Equipe inválida!");
                    } else {
                        funcionario.setEquipe(equipe);
                    }
                }
                break;
            case 5:
                System.out.println("Qual sera o novo cargo deste funcionario: ");
                System.out.println("1 --- Colaborador");
                System.out.println("2 --- Gerente de Departamento");
                System.out.println("3 --- Gerente Geral");
                System.out.println("4 --- Lider Tecnico");
                int opcaoCargo = lerTeclado.lerInteger("Opcao: ");
                switch (opcaoCargo) {
                    case 1 -> {
                        Colaborador novoColaborador = new Colaborador(funcionario.getNome(), funcionario.getSobrenome(), funcionario.getCpf(), funcionario.getSalario(), funcionario.getEquipe());
                        FuncionarioRepository.funcionariosAtivos.remove(funcionario);
                        FuncionarioRepository.todosFuncionarios.remove(funcionario);
                        FuncionarioRepository.funcionariosAtivos.add(novoColaborador);
                        FuncionarioRepository.todosFuncionarios.add(novoColaborador);
                        System.out.println("Cargo atualizado com sucesso!");
                    }
                    case 2 -> {
                        GerenteDeDepartamento novoGerenteDeDepartamento = new GerenteDeDepartamento(funcionario.getNome(), funcionario.getSobrenome(), funcionario.getCpf(), funcionario.getSalario(), funcionario.getEquipe());
                        FuncionarioRepository.funcionariosAtivos.remove(funcionario);
                        FuncionarioRepository.todosFuncionarios.remove(funcionario);
                        FuncionarioRepository.funcionariosAtivos.add(novoGerenteDeDepartamento);
                        FuncionarioRepository.todosFuncionarios.add(novoGerenteDeDepartamento);
                        System.out.println("Cargo atualizado com sucesso!");
                    }
                    case 3 -> {
                        GerenteGeral novoGerenteGeral = new GerenteGeral(funcionario.getNome(), funcionario.getSobrenome(), funcionario.getCpf(), funcionario.getSalario(), funcionario.getEquipe());
                        FuncionarioRepository.funcionariosAtivos.remove(funcionario);
                        FuncionarioRepository.todosFuncionarios.remove(funcionario);
                        FuncionarioRepository.funcionariosAtivos.add(novoGerenteGeral);
                        FuncionarioRepository.todosFuncionarios.add(novoGerenteGeral);
                        System.out.println("Cargo atualizado com sucesso!");
                    }
                    case 4 -> {
                        LiderTecnico novoLiderTecnico = new LiderTecnico(funcionario.getNome(), funcionario.getSobrenome(), funcionario.getCpf(), funcionario.getSalario(), funcionario.getEquipe());
                        FuncionarioRepository.funcionariosAtivos.remove(funcionario);
                        FuncionarioRepository.todosFuncionarios.remove(funcionario);
                        FuncionarioRepository.funcionariosAtivos.add(novoLiderTecnico);
                        FuncionarioRepository.todosFuncionarios.add(novoLiderTecnico);
                        System.out.println("Cargo atualizado com sucesso!");
                    }
                }
        }
    }


}
