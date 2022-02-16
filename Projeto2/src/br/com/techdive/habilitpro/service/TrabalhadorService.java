package br.com.techdive.habilitpro.service;

import br.com.techdive.habilitpro.domain.Empresa;
import br.com.techdive.habilitpro.domain.Trabalhador;
import br.com.techdive.habilitpro.domain.Usuario;
import br.com.techdive.habilitpro.repository.EmpresaRepository;
import br.com.techdive.habilitpro.repository.TrabalhadorRepository;
import br.com.techdive.habilitpro.repository.TrilhaRepository;
import br.com.techdive.habilitpro.representation.request.TrabalhadorRequestRepresentation;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class TrabalhadorService {

    private static final String CPF_REGEX = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})";

    public void cadastrarTrabalhador(TrabalhadorRequestRepresentation request, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        Empresa empresaEncontrada = EmpresaRepository.empresas.get(request.getCnpjEmpresa());
        if (isNull(empresaEncontrada)) {
            throw new RuntimeException("CNPJ não vinculado a uma empresa cadastrada!");
        }
        verificaTrabalhador(request.getNome(), request.getSetor(), request.getFuncao());
        verificaCpf(request.getCpf());

        Trabalhador trabalhador = Trabalhador.builder()
                .id((long) (TrabalhadorRepository.trabalhadores.size() + 1))
                .empresa(empresaEncontrada)
                .nome(request.getNome())
                .cpf(request.getCpf())
                .setor(request.getSetor())
                .funcao(request.getFuncao())
                .ultimaAlteracaoFuncao(LocalDateTime.now())
                .trilhas(request.getTrilhas())
                .modulos(request.getModulos())
                .build();
        TrabalhadorRepository.trabalhadores.put(trabalhador.getCpf(), trabalhador);
    }

    public void adicionarTrilha(String nomeTrilha, String cpf, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaAdicionar(usuario);
        verificaCpf(cpf);
        retornaTrabalhador(cpf)
                .getTrilhas()
                .add(TrilhaRepository.trilhas
                        .stream()
                        .filter(trilha -> trilha.getNome().equalsIgnoreCase(nomeTrilha))
                        .findFirst()
                        .orElseThrow());
    }

    public void alterarFuncao(String funcao, String cpf, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaAlterar(usuario);
        verificaCpf(cpf);
        Trabalhador trabalhador = retornaTrabalhador(cpf);
        verificaFuncao(funcao, trabalhador.getFuncao());
        trabalhador.setFuncao(funcao);
    }

    public void alterarEmpresa(String cpf, String cnpj) {
        verificaCpf(cpf);
        EmpresaService.verificaCnpj(cnpj);
        Trabalhador trabalhador = TrabalhadorRepository.trabalhadores.get(cpf);
        Empresa empresa = EmpresaRepository.empresas.get(cnpj);
        trabalhador.setEmpresa(empresa);
    }

    private Trabalhador retornaTrabalhador(String cpf) {
        Trabalhador trabalhadorEncontrado = TrabalhadorRepository.trabalhadores.get(cpf);
        if (isNull(trabalhadorEncontrado)) {
            throw new RuntimeException("CPF não cadastrado!");
        }
        return trabalhadorEncontrado;
    }

    private void verificaFuncao(String novaFuncao, String funcaoTrabalhador) {
        if (novaFuncao.equalsIgnoreCase(funcaoTrabalhador)) {
            throw new RuntimeException("Está já é a função atual do trabalhador!");
        }
    }

    private void verificaTrabalhador(String nome, String setor, String funcao) {
        if (nome.isEmpty() || nome.isBlank()) {
            throw new RuntimeException("O trabalhador deve ter um nome!");
        }
        if (setor.isEmpty() || setor.isBlank()) {
            throw new RuntimeException("O trabalhador deve ter um setor!");
        }
        if (funcao.isEmpty() || funcao.isBlank()) {
            throw new RuntimeException("O trabalhador deve ter uma função!");
        }
    }

    private void verificaCpf(String cpf) {
        if (!cpf.matches(CPF_REGEX)) {
            throw new RuntimeException("CPF está em um formato inválido!");
        }
    }


}
