package br.com.techdive.ferias.projeto2.domain;

import br.com.techdive.ferias.projeto2.repository.TurmaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Integer id;
    private String nomeTurma;
    private int quantidadeAlunos;
    private LocalDate dataInicioAulas;
    public List<Docente> docentes;

    public List<Semana> semanas;

    public Turma(String nomeTurma, int quantidadeAlunos, LocalDate dataInicioAulas) {
        this.nomeTurma = nomeTurma;
        this.quantidadeAlunos = quantidadeAlunos;
        this.dataInicioAulas = dataInicioAulas;
        this.id = TurmaRepository.turmas.size() + 1;
        this.docentes = new ArrayList<>();
        this.semanas = new ArrayList<>(52);
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public LocalDate getDataInicioAulas() {
        return dataInicioAulas;
    }
}
