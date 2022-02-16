package main.br.com.techdive.habilitpro.service;

import main.br.com.techdive.habilitpro.domain.PerfilAcesso;
import main.br.com.techdive.habilitpro.domain.Usuario;

public class VerificaPerfilAcesso {

    public static void verificaPerfilParaCadastro(Usuario usuario) {
        if(!usuario.getPerfisAcesso().contains(PerfilAcesso.ADMINISTRATIVO)) {
            throw new RuntimeException("Acesso negado! Este usuário não tem permissão para cadastrar!");
        }
    }

    public static void verificaPerfilParaAdicionar(Usuario usuario) {
        if(!usuario.getPerfisAcesso().contains(PerfilAcesso.ADMINISTRATIVO)) {
            throw new RuntimeException("Acesso negado! Este usuário não tem permissão para adicionar!");
        }
    }

    public static void verificaPerfilParaAlterar(Usuario usuario) {
        if(!usuario.getPerfisAcesso().contains(PerfilAcesso.ADMINISTRATIVO)) {
            throw new RuntimeException("Acesso negado! Este usuário não tem permissão para alterar!");
        }
    }

    public static void verificaPerfilParaAvaliar(Usuario usuario) {
        if(usuario.getPerfisAcesso().contains(PerfilAcesso.OPERACIONAL) || usuario.getPerfisAcesso().contains(PerfilAcesso.ADMINISTRATIVO)) {
            System.out.println("");
        } else {
            throw new RuntimeException("Acesso negado! Este usuário não tem permissão para adicionar!");
        }
    }

}
