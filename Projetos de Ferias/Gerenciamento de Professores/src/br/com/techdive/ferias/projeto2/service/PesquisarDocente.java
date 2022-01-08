package br.com.techdive.ferias.projeto2.service;

import br.com.techdive.ferias.projeto2.domain.Docente;
import br.com.techdive.ferias.projeto2.repository.DocenteRepository;

public class PesquisarDocente {

    public static Docente pesquisarDocente() {
        Teclado lerTeclado = new Teclado();
        String nome = lerTeclado.lerString("Nome completo do docente: ");
        return DocenteRepository.docentes.stream().filter(e -> e.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }
}
