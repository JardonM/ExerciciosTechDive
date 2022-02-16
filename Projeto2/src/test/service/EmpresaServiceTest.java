package test.service;

import main.br.com.techdive.habilitpro.domain.PerfilAcesso;
import main.br.com.techdive.habilitpro.domain.Usuario;
import main.br.com.techdive.habilitpro.repository.EmpresaRepository;
import main.br.com.techdive.habilitpro.representation.request.EmpresaRequestRepresentation;
import main.br.com.techdive.habilitpro.service.EmpresaService;

import java.util.List;

public class EmpresaServiceTest {

    public static void main(String[] args) {
        EmpresaService empresaService = new EmpresaService();

        Usuario usuario = Usuario.builder()
                .cpf("010.020.030-01")
                .email("primeiro@usuario.com")
                .nome("Primeiro Usuario")
                .senha("Pr1m3ir0")
                .perfisAcesso(List.of(PerfilAcesso.ADMINISTRATIVO, PerfilAcesso.OPERACIONAL))
                .build();

        empresaService.cadastrarEmpresa(EmpresaRequestRepresentation.builder()
                .cnpj("01.020.030/0001-01")
                .tipoEmpresa("matriz")
                .nome("Primeira Empresa")
                .segmentoAtuacao("Alimentos e bebidas")
                .build(), usuario);

        System.out.println(EmpresaRepository.empresas.get("01.020.030/0001-01"));
    }
}
