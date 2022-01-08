package br.com.techdive.ferias.projeto2.service.menu;

import br.com.techdive.ferias.projeto2.domain.Docente;
import br.com.techdive.ferias.projeto2.domain.Turma;
import br.com.techdive.ferias.projeto2.repository.DocenteRepository;
import br.com.techdive.ferias.projeto2.repository.TurmaRepository;
import br.com.techdive.ferias.projeto2.service.PesquisarDocente;
import br.com.techdive.ferias.projeto2.service.Teclado;

import java.time.temporal.ChronoUnit;

public class DefinirDocenteParaTurma {

    public static void definirDocenteParaTurma() {
        Teclado lerTeclado = new Teclado();
        String nomeTurma = lerTeclado.lerString("Nome da turma: ");
        Turma turma = TurmaRepository.turmas.stream().filter(e -> e.getNomeTurma().equalsIgnoreCase(nomeTurma)).findFirst().orElse(null);
        if(turma == null){
            System.out.println("Turma não encontrada!");
        } else {
            int numeroSemana = lerTeclado.lerInteger("Gostaria de definir docente para qual semana de aula? (1-52)");
            if(turma.semanas.get(numeroSemana).getEscala1() == null && turma.semanas.get(numeroSemana).getEscala2() != null) {
                Docente docente = PesquisarDocente.pesquisarDocente();
                if (docente == null) {
                    System.out.println("Docente não encontrado!");
                } else {
                    turma.semanas.get(numeroSemana).setEscala1(docente);
                    turma.docentes.add(docente);
                    System.out.println("Docente " + docente.getNome() + " definido para a Escala 1 da semana " + numeroSemana + " que iniciará na data " + ChronoUnit.WEEKS.addTo(turma.getDataInicioAulas(), numeroSemana));
                }
            }
            if(turma.semanas.get(numeroSemana).getEscala2() == null && turma.semanas.get(numeroSemana).getEscala1() != null) {
                Docente docente = PesquisarDocente.pesquisarDocente();
                if (docente == null) {
                    System.out.println("Docente não encontrado!");
                } else {
                    turma.semanas.get(numeroSemana).setEscala2(docente);
                    turma.docentes.add(docente);
                    System.out.println("Docente " + docente.getNome() + " definido para a Escala 2 da semana " + numeroSemana + " que iniciará na data " + ChronoUnit.WEEKS.addTo(turma.getDataInicioAulas(), numeroSemana));
                }
            }
            if(turma.semanas.get(numeroSemana).getEscala1() == null && turma.semanas.get(numeroSemana).getEscala2() == null) {
                Docente docente = PesquisarDocente.pesquisarDocente();
                if(docente == null) {
                    System.out.println("Docente não encontrado!");
                } else {
                    System.out.println("Escalar " + docente.getNome() + " para quais escalas desta semana?");
                    System.out.println("1 --- Escala 1");
                    System.out.println("2 --- Escala 2");
                    System.out.println("3 --- Ambas Escalas");
                    int opcaoEscala = lerTeclado.lerInteger("Opcao: ");
                    switch (opcaoEscala) {
                        case 1 -> {
                            turma.semanas.get(numeroSemana).setEscala1(docente);
                            turma.docentes.add(docente);
                            System.out.println("Docente " + docente.getNome() + " definido para a Escala 1 da semana " + numeroSemana + " que iniciará na data " + ChronoUnit.WEEKS.addTo(turma.getDataInicioAulas(), numeroSemana));
                        }
                        case 2 -> {
                            turma.semanas.get(numeroSemana).setEscala2(docente);
                            turma.docentes.add(docente);
                            System.out.println("Docente " + docente.getNome() + " definido para a Escala 2 da semana " + numeroSemana + " que iniciará na data " + ChronoUnit.WEEKS.addTo(turma.getDataInicioAulas(), numeroSemana));
                        }
                        case 3 -> {
                            turma.semanas.get(numeroSemana).setEscala1(docente);
                            turma.semanas.get(numeroSemana).setEscala2(docente);
                            turma.docentes.add(docente);
                            System.out.println("Docente " + docente.getNome() + " definido para ambas escalas da semana " + numeroSemana + " que iniciará na data " + ChronoUnit.WEEKS.addTo(turma.getDataInicioAulas(), numeroSemana));
                        }
                    }
                }

            }
        }
    }



}

