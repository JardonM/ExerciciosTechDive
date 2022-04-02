package service;

import model.entities.PerfilAcesso;
import model.entities.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VerificaPerfilAcesso {

    private static final Logger LOG = LogManager.getLogger(VerificaPerfilAcesso.class);

    public static void verificaPerfilParaCadastro(Usuario usuario) {
        LOG.info("Verificando perfil de acesso para cadastro");
        if (!usuario.getPerfisAcesso().contains(PerfilAcesso.ADMINISTRATIVO)) {
            LOG.info("Acesso negado! Este usuário não tem permissão para cadastrar!");
            throw new RuntimeException("Acesso negado! Este usuário não tem permissão para cadastrar!");
        }
        LOG.info("Acesso concedido! Este usuário tem permissão para cadastrar!");
    }

    public static void verificaPerfilParaAdicionar(Usuario usuario) {
        LOG.info("Verificando perfil de acesso para adicionar");
        if (!usuario.getPerfisAcesso().contains(PerfilAcesso.ADMINISTRATIVO)) {
            LOG.info("Acesso negado! Este usuário não tem permissão para adicionar!");
            throw new RuntimeException("Acesso negado! Este usuário não tem permissão para adicionar!");
        }
        LOG.info("Acesso concedido! Este usuário tem permissão para adicionar!");
    }

    public static void verificaPerfilParaAlterar(Usuario usuario) {
        LOG.info("Verificando perfil de acesso para alterar");
        if (!usuario.getPerfisAcesso().contains(PerfilAcesso.ADMINISTRATIVO)) {
            LOG.info("Acesso negado! Este usuário não tem permissão para alterar!");
            throw new RuntimeException("Acesso negado! Este usuário não tem permissão para alterar!");
        }
        LOG.info("Acesso concedido! Este usuário tem permissão para alterar!");
    }

    public static void verificaPerfilParaAvaliar(Usuario usuario) {
        LOG.info("Verificando perfil de acesso para avaliar");
        if (usuario.getPerfisAcesso().contains(PerfilAcesso.OPERACIONAL) || usuario.getPerfisAcesso().contains(PerfilAcesso.ADMINISTRATIVO)) {
            LOG.info("Acesso concedido! Este usuário tem permissão para avaliar!");
        } else {
            LOG.info("Acesso negado! Este usuário não tem permissão para avaliar!");
            throw new RuntimeException("Acesso negado! Este usuário não tem permissão para avaliar!");
        }
    }

}
