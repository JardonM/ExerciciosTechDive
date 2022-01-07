package br.com.techdive.ferias.projeto2.domain;

import br.com.techdive.ferias.projeto2.repository.DocenteRepository;

public class Docente {
    private Integer id;
    private String nome;
    private Turma turmaAtendidaAtualmente;

    public Docente(String nome) {
        this.nome = nome;
        this.id = DocenteRepository.docentes.size() + 1;
    }

    public String getNome() {
        return nome;
    }

    public void setTurmaAtendidaAtualmente(Turma turmaAtendidaAtualmente) {
        this.turmaAtendidaAtualmente = turmaAtendidaAtualmente;
    }
}
