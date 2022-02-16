package main.br.com.techdive.habilitpro.service;

import main.br.com.techdive.habilitpro.domain.PerfilAcesso;
import main.br.com.techdive.habilitpro.domain.Usuario;
import main.br.com.techdive.habilitpro.repository.UsuarioRepository;
import main.br.com.techdive.habilitpro.representation.request.UsuarioRequestRepresentation;

import java.util.List;

import static java.util.Objects.isNull;

public class UsuarioService {

    private static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String CPF_REGEX = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})";

    public void cadastrarUsuario(UsuarioRequestRepresentation request) {
        verificaCpf(request.getCpf());
        verificaEmail(request.getEmail());
        verificaSenha(request.getSenha());

        UsuarioRepository.usuarios.put(request.getCpf(), Usuario.builder()
                .cpf(request.getCpf())
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(request.getSenha())
                .perfisAcesso(request.getPerfisAcesso())
                .build());

    }

    public void alterarPerfisAcesso(String cpf, List<PerfilAcesso> perfisAcesso) {
        verificaCpf(cpf);
        Usuario usuario = UsuarioRepository.usuarios.get(cpf);
        if (isNull(usuario)) {
            throw new RuntimeException("Usuário não cadastrado!");
        }
        usuario.setPerfisAcesso(perfisAcesso);
    }

    private void verificaCpf(String cpf) {
        if (!cpf.matches(CPF_REGEX)) {
            throw new RuntimeException("CPF está em um formato inválido!");
        }
    }

    private void verificaEmail(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            throw new RuntimeException("Email está em um formato inválido!");
        }
    }

    private void verificaSenha(String senha) {
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
        if (numero && letra && tamanho) {
            throw new RuntimeException("A senha deve conter ao menos 8 caracteres contendo entre letras e números!");
        }
    }


}
