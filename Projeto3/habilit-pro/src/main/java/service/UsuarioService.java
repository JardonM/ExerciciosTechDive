package service;

import model.dao.UsuarioRepository;
import model.entities.PerfilAcesso;
import model.entities.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import representation.request.UsuarioRequestRepresentation;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioService {

    private static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String CPF_REGEX = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})";
    private final Logger LOG = LogManager.getLogger(UsuarioService.class);
    private final UsuarioRepository usuarioRepository;
    private EntityManager entityManager;

    public UsuarioService(EntityManager entityManager) {
        this.usuarioRepository = new UsuarioRepository(entityManager);
        this.entityManager = entityManager;
    }

    public void cadastrarUsuario(UsuarioRequestRepresentation request) {
        this.LOG.info("Inicio do processo de cadastro de usuário");
        verificaCpf(request.getCpf());
        verificaEmail(request.getEmail());
        verificaSenha(request.getSenha());
        this.LOG.info("Cadastrando usuário");
        getBeginTransaction();
        usuarioRepository.create(Usuario.builder()
                .cpf(request.getCpf())
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(request.getSenha())
                .perfisAcesso(request.getPerfisAcesso())
                .build());
        this.LOG.info("Usuário cadastrado com sucesso!");
        commitAndCloseTransaction();
    }

    public void alterarPerfisAcesso(String cpf, List<PerfilAcesso> perfisAcesso) {
        this.LOG.info("Inicio do processo de alteração de perfis de acesso");
        verificaCpf(cpf);
        this.LOG.info("Alterando perfis de acesso");
        Usuario usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> {
                    this.LOG.error("Usuário não encontrado!");
                    return new RuntimeException("Cpf não cadastrado!");
                });

        usuario.setPerfisAcesso(perfisAcesso);
        usuarioRepository.update(usuario);
        this.LOG.info("Perfis de acesso alterados com sucesso!");
    }

    private void verificaCpf(String cpf) {
        this.LOG.info("Verificando se o cpf é válido");
        if (!cpf.matches(CPF_REGEX)) {
            this.LOG.error("Cpf inválido!");
            throw new RuntimeException("CPF está em um formato inválido!");
        }
        this.LOG.info("Cpf válido!");
    }

    private void verificaEmail(String email) {
        this.LOG.info("Verificando se o email é válido");
        if (!email.matches(EMAIL_REGEX)) {
            this.LOG.error("Email inválido!");
            throw new RuntimeException("Email está em um formato inválido!");
        }
        this.LOG.info("Email válido!");
    }

    private void verificaSenha(String senha) {
        this.LOG.info("Verificando se a senha é válida");
        boolean numero = true;
        boolean letra = true;
        boolean tamanho = true;
        if (senha.length() < 8) {
            tamanho = false;
        }
        for (char c : senha.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numero = false;
            } else if (c >= 'A' && c <= 'Z') {
                letra = false;
            } else if (c >= 'a' && c <= 'z') {
                letra = false;
            }
        }
        if (numero || letra || tamanho) {
            this.LOG.error("Senha inválida!");
            throw new RuntimeException("A senha deve conter ao menos 8 caracteres contendo entre letras e números!");
        }
        this.LOG.info("Senha válida!");
    }

    private void getBeginTransaction() {
        this.LOG.info("Abrindo Transação com o banco de dados...");
        entityManager.getTransaction().begin();
    }

    private void commitAndCloseTransaction() {
        this.LOG.info("Commitando e Fechando transação com o banco de dados");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
