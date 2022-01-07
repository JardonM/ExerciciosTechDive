package br.com.techdive.ferias.projeto2.service;

public class VerificarDadosTurma {

    public static boolean dadosEstaoCorretos (String nome, int quantiaAlunos, String assuntos, String dataInicio) {
        return !nome.isEmpty() || !nome.isBlank() || !assuntos.isEmpty() || !assuntos.isBlank() || !dataInicio.isEmpty() || !dataInicio.isBlank() || quantiaAlunos >= 1;
    }
}
