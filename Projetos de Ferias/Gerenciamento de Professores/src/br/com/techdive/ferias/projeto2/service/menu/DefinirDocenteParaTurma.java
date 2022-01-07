package br.com.techdive.ferias.projeto2.service.menu;

import br.com.techdive.ferias.projeto2.domain.Docente;
import br.com.techdive.ferias.projeto2.domain.Turma;
import br.com.techdive.ferias.projeto2.repository.DocenteRepository;
import br.com.techdive.ferias.projeto2.repository.TurmaRepository;
import br.com.techdive.ferias.projeto2.service.Teclado;

public class DefinirDocenteParaTurma {

    public static void definirDocenteParaTurma() {
        Teclado lerTeclado = new Teclado();
        String nome = lerTeclado.lerString("Nome do docente: ");
        Docente docente = DocenteRepository.docentes.stream().filter(e -> e.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
        if(docente == null) {
            System.out.println("Docente não encontrado!");
        } else {
            String nomeTurma = lerTeclado.lerString("Nome da turma: ");
            Turma turma = TurmaRepository.turmas.stream().filter(e -> e.getNomeTurma().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if(turma == null){
                System.out.println("Turma não encontrada!");
            } else {
                turma.docentes.add(docente);
                docente.setTurmaAtendidaAtualmente(turma);

            }
        }
    }
}
