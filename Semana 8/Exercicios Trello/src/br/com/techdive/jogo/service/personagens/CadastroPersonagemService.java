package br.com.techdive.jogo.service.personagens;

import br.com.techdive.jogo.domain.enums.Arma;
import br.com.techdive.jogo.domain.enums.Motivacao;
import br.com.techdive.jogo.domain.personagens.Personagem;
import br.com.techdive.jogo.domain.personagens.jogador.*;
import br.com.techdive.jogo.service.Teclado;

public class CadastroPersonagemService {

    public Jogador cadastrarPersonagem() throws Exception {
        Teclado teclado = new Teclado();
        String nomePersonagem = teclado.lerString("Nome do personagem: ");
        System.out.println("Voce pode criar um personagem do sexo Masculino ou Feminino");
        String sexoPersonagem = teclado.lerString("Qual sera o sexo do personagem? (M/F)");
        System.out.println("----- CLASSES -----");
        System.out.println("Voce pode escolher entre:");
        System.out.print("Guerreiro\nPaladino\nArqueiro\nMago\n");
        String classePersonagem = teclado.lerString("Qual sera a classe do personagem?");
        return verificarDadosPersonagem(nomePersonagem, sexoPersonagem, classePersonagem);
    }

    private Jogador verificarDadosPersonagem(String nome, String sexo, String classe) throws Exception {
        verificaNomeESexo(nome, sexo);
        Teclado teclado = new Teclado();
        String armaPersonagem;

        if (classe.equalsIgnoreCase("arqueiro")) {
            System.out.print("Escolha uma arma para seu Arqueiro:\n" + Arma.ARCO.name() + ";\n" + Arma.BESTA.name() + ";\n");
            armaPersonagem = teclado.lerString("Arma desejada para o personagem: ");
            if (!armaPersonagem.equalsIgnoreCase("arco") && !armaPersonagem.equalsIgnoreCase("besta")) {
                throw new Exception("Arma invalida para a classe selecionada!");
            } else {
                return setarPersonagemComArma(nome, sexo, armaPersonagem);
            }
        } else if (classe.equalsIgnoreCase("Guerreiro")) {
            System.out.println("Escolha uma arma para seu Guerreiro:\n " + Arma.ESPADA.name() + ";\n" + Arma.MACHADO.name() + ";\n");
            armaPersonagem = teclado.lerString("Arma desejada para o personagem: ");
            if (!armaPersonagem.equalsIgnoreCase("espada") && !armaPersonagem.equalsIgnoreCase("machado")) {
                throw new Exception("Arma invalida para a classe selecionada!");
            } else {
                return setarPersonagemComArma(nome, sexo, armaPersonagem);
            }
        } else if (classe.equalsIgnoreCase("Mago")) {
            System.out.println("Escolha uma arma para seu Mago:\n" + Arma.CAJADO.getDescricao() + ";\n" + Arma.LIVRO_DE_MAGIAS.getDescricao() + ";\n");
            armaPersonagem = teclado.lerString("Arma desejada para o personagem: ");
            if (!armaPersonagem.equalsIgnoreCase("cajado") && !armaPersonagem.equalsIgnoreCase("magic book")) {
                throw new Exception("Arma invalida para a classe selecionada!");
            } else {
                return setarPersonagemComArma(nome, sexo, armaPersonagem);
            }
        } else if (classe.equalsIgnoreCase("Paladino")) {
            System.out.println("Escolha uma arma para seu Paladino:\n" + Arma.CLAVA.name() + ";\n" + Arma.MARTELO.name() + ";\n");
            armaPersonagem = teclado.lerString("Arma desejada para o personagem: ");
            if (!armaPersonagem.equalsIgnoreCase("clava") && !armaPersonagem.equalsIgnoreCase("martelo")) {
                throw new Exception("Arma invalida para a classe selecionada!");
            } else {
                return setarPersonagemComArma(nome, sexo, armaPersonagem);
            }
        } else {
            throw new Exception("Personagem invalido!");
        }
    }


    private Jogador setarPersonagemComArma(String nome, String sexo, String armaPersonagem) {
        if(armaPersonagem.equalsIgnoreCase("arco")) {
            return new Arqueiro(nome, sexo, Arma.ARCO);
        } else if(armaPersonagem.equalsIgnoreCase("besta")) {
            return new Arqueiro(nome, sexo, Arma.BESTA);
        } else if(armaPersonagem.equalsIgnoreCase("espada")) {
            return new Guerreiro(nome, sexo, Arma.ESPADA);
        } else if(armaPersonagem.equalsIgnoreCase("machado")) {
            return new Guerreiro(nome, sexo, Arma.MACHADO);
        } else if(armaPersonagem.equalsIgnoreCase("cajado")) {
            return new Mago(nome, sexo, Arma.CAJADO);
        } else if(armaPersonagem.equalsIgnoreCase("magic book")) {
            return new Mago(nome, sexo, Arma.LIVRO_DE_MAGIAS);
        } else if(armaPersonagem.equalsIgnoreCase("martelo")) {
            return new Paladino(nome, sexo, Arma.MARTELO);
        } else if(armaPersonagem.equalsIgnoreCase("clava")) {
            return new Paladino(nome, sexo, Arma.CLAVA);
        } else {
            return null;
        }
    }

    private void verificaNomeESexo(String nome, String sexo) throws Exception {
        if (nome.isEmpty() || nome.isBlank()) {
            throw new Exception("Nome invalido!");
        }
        if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
            throw new Exception("Sexo invalido!");
        }
    }

}
