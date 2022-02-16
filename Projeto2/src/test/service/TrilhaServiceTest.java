package test.service;

import main.br.com.techdive.habilitpro.domain.Empresa;
import main.br.com.techdive.habilitpro.domain.Modulo;
import main.br.com.techdive.habilitpro.domain.Trilha;
import main.br.com.techdive.habilitpro.domain.Usuario;
import main.br.com.techdive.habilitpro.repository.EmpresaRepository;
import main.br.com.techdive.habilitpro.repository.ModuloRepository;
import main.br.com.techdive.habilitpro.repository.TrilhaRepository;
import main.br.com.techdive.habilitpro.representation.request.TrilhaRequestRepresentation;
import main.br.com.techdive.habilitpro.service.TrilhaService;
import test.fixture.EmpresaFixture;
import test.fixture.ModuloFixture;
import test.fixture.UsuarioFixture;

public class TrilhaServiceTest {

    public static void main(String[] args) {

        TrilhaService trilhaService = new TrilhaService();
        Empresa empresa = EmpresaFixture.get().withRandomData().build();
        EmpresaRepository.empresas.put(empresa.getCnpj(), empresa);
        Usuario usuario = UsuarioFixture.get().withRandomData().build();

        trilhaService.cadastrarTrilha(TrilhaRequestRepresentation.builder()
                        .cnpjEmpresa(empresa.getCnpj())
                        .ocupacao("Ocupacao")
                        .anotacoes("anotações")
                .build(), usuario);
        System.out.println(TrilhaRepository.trilhas.get(0));
        Trilha trilha = TrilhaRepository
                .trilhas
                .get(0);
        trilhaService.avaliarTrilha(trilha.getNome(), 5, usuario);
        System.out.println(TrilhaRepository.trilhas.get(0));
        Modulo modulo = ModuloFixture.get()
                .withRandomData()
                .withTrilha(trilha)
                .build();
        ModuloRepository.modulos.add(modulo);
        trilhaService.adicionarModulo(trilha.getNome(), modulo.getId(), usuario);
        System.out.println(TrilhaRepository.trilhas.get(0));
    }

}
