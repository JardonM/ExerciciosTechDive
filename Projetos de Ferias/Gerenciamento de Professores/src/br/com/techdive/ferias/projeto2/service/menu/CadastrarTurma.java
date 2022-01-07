package br.com.techdive.ferias.projeto2.service.menu;

import br.com.techdive.ferias.projeto2.domain.Turma;
import br.com.techdive.ferias.projeto2.service.Teclado;
import br.com.techdive.ferias.projeto2.service.VerificarDadosTurma;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CadastrarTurma {


    public static Turma cadastrarTurma() {
        Teclado lerTeclado = new Teclado();
        boolean dadosVerificados;
        String nome;
        int quantidadeAlunos;
        String assuntos;
        String dataInicioString;
        System.out.println("---- CADASTRO DE TURMA ----");
        do {
            nome = lerTeclado.lerString("Nome da turma: ");
            quantidadeAlunos = lerTeclado.lerInteger("Quantidade de alunos: ");
            assuntos = lerTeclado.lerString("Assuntos: ");
            dataInicioString = lerTeclado.lerString("Insira a data de inicio das aulas (dd/MM/yyyy): ");
            dadosVerificados = VerificarDadosTurma.dadosEstaoCorretos(nome, quantidadeAlunos, assuntos, dataInicioString);
            if(!dadosVerificados) {
                System.out.println("Dados incorretos, favor refazer cadastro!");
            }
        }while(!dadosVerificados);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(dataInicioString, formatter);

        return new Turma(nome, quantidadeAlunos, assuntos, dataInicio);
    }

}
