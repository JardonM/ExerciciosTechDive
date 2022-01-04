package br.com.techdive.ferias.projeto1.service.menu;

import br.com.techdive.ferias.projeto1.domain.Funcionario;
import br.com.techdive.ferias.projeto1.request.FuncionarioRequest;
import br.com.techdive.ferias.projeto1.service.*;

import java.util.HashMap;

public class AdicionarFuncionario {


    public static void adicionarFuncionario() {
        HashMap<Integer, CriarFuncionario> criarFuncionarioMap = new HashMap<>();
        criarFuncionarioMap.put(1, new CriarFuncionarioColaborador());
        criarFuncionarioMap.put(2, new CriarFuncionarioGerenteDeDepartamento());
        criarFuncionarioMap.put(3, new CriarFuncionarioGerenteGeral());
        criarFuncionarioMap.put(4, new CriarFuncionarioLiderTecnico());
        Teclado lerTeclado = new Teclado();
        boolean dadosCorretos = false;
        FuncionarioRequest funcionarioRequest = new FuncionarioRequest();
        int opcaoCargo;
        while (!dadosCorretos) {
            System.out.println("--- CADASTRO DE FUNCIONARIOS ---");
            funcionarioRequest.setNome(lerTeclado.lerString("Nome: "));
            funcionarioRequest.setSobrenome(lerTeclado.lerString("Sobrenome: "));
            funcionarioRequest.setCpf(lerTeclado.lerString("CPF(apenas numeros - 11 digitos): "));
            funcionarioRequest.setSalario(lerTeclado.lerDouble("Salario: "));
            System.out.println("Selecione o cargo do novo funcionario:");
            System.out.println("1 --- Colaborador");
            System.out.println("2 --- Gerente de Departamento");
            System.out.println("3 --- Gerente Geral");
            System.out.println("4 --- Lider Tecnico");
            opcaoCargo = lerTeclado.lerInteger("Opcao:");
            dadosCorretos = VerificarDadosFuncionario.verificar(funcionarioRequest);
            CriarFuncionario retornoMap = criarFuncionarioMap.get(opcaoCargo);
            if(retornoMap != null) {
                Funcionario novoFuncionario = retornoMap.criarFuncionario(funcionarioRequest);
                System.out.println("Funcionario cadastrado com sucesso!");
            } else {
                System.out.println("Opcao inválida!");
                dadosCorretos = false;
            }
        }
    }

}
