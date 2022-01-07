package br.com.techdive.ferias.projeto2.domain;

import br.com.techdive.ferias.projeto2.repository.TurmaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Integer id;
    private String nomeTurma;
    private int quantidadeAlunos;
    private String assuntos;
    private LocalDate dataInicioAulas;
    public List<Docente> docentes;

    public Turma(String nomeTurma, int quantidadeAlunos, String assuntos, LocalDate dataInicioAulas) {
        this.nomeTurma = nomeTurma;
        this.quantidadeAlunos = quantidadeAlunos;
        this.assuntos = assuntos;
        this.dataInicioAulas = dataInicioAulas;
        this.id = TurmaRepository.turmas.size() + 1;
        this.docentes = new ArrayList<>();
    }

    public String getNomeTurma() {
        return nomeTurma;
    }
}
