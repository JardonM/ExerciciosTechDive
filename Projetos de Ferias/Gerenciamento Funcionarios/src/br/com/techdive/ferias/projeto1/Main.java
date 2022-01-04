package br.com.techdive.ferias.projeto1;


import br.com.techdive.ferias.projeto1.repository.FuncionarioRepository;
import br.com.techdive.ferias.projeto1.service.PopularListasFuncionarios;
import br.com.techdive.ferias.projeto1.service.Teclado;
import br.com.techdive.ferias.projeto1.service.menu.AdicionarFuncionario;
import br.com.techdive.ferias.projeto1.service.menu.AtualizarInfoFuncionario;
import br.com.techdive.ferias.projeto1.service.menu.DemitirFuncionario;
import br.com.techdive.ferias.projeto1.service.menu.DetalhesFuncionario;



public class Main {

    public static void main(String[] args) {

        Teclado lerTeclado = new Teclado();
        PopularListasFuncionarios.popularListas();


        int opcao = 0;
        while(opcao != 8) {
            System.out.println("Gerenciamento de funcionarios: ");
            System.out.println("1 --- Adicionar funcionario");
            System.out.println("2 --- Ver detalhes de um funcionario");
            System.out.println("3 --- Demitir funcionario");
            System.out.println("4 --- Atualizar informacoes de um funcionario");
            System.out.println("5 --- Listar todos os funcionarios");
            System.out.println("6 --- Listar somente funcionarios trabalhando");
            System.out.println("7 --- Listar funcionarios demitidos");
            System.out.println("8 --- Sair");
            opcao = lerTeclado.lerInteger("Opcao: ");
            switch (opcao) {
                case 1 -> {
                    AdicionarFuncionario.adicionarFuncionario();
                }
                case 2 -> DetalhesFuncionario.verDetalhesFuncionario();
                case 3 -> DemitirFuncionario.demitirFuncionario();
                case 4 -> AtualizarInfoFuncionario.atualizarInfoFuncionario();
                case 5 -> FuncionarioRepository.todosFuncionarios.forEach(e -> System.out.println(e.toString()));
                case 6 -> FuncionarioRepository.funcionariosAtivos.forEach(e -> System.out.println(e.toString()));
                case 7 -> FuncionarioRepository.funcionariosDemitidos.forEach(e -> System.out.println(e.toString()));
            }
        }

    }

}
