package br.com.techdive.ferias.projeto2.service.menu;

import br.com.techdive.ferias.projeto2.domain.Docente;
import br.com.techdive.ferias.projeto2.service.Teclado;

public class CadastrarDocentes {

    public static Docente cadastrarDocente() {
        Teclado lerTeclado = new Teclado();
        String nome = "";
        System.out.println("---- CADASTRO DE DOCENTES ----");
        do{
            nome = lerTeclado.lerString("Nome do Docente: ");
        }while (nome.isEmpty() || nome.isBlank());
        return new Docente(nome);
    }
}
