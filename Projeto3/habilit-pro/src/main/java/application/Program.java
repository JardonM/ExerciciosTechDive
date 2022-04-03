package application;

import connection.JpaConnectionFactory;
import fixture.EmpresaRequestRepresentationFixture;
import fixture.UsuarioFixture;
import lombok.var;
import model.dao.*;
import service.*;

import javax.persistence.EntityManager;

public class Program {
    public static void main(String[] args) {

        EntityManager entityManager = new JpaConnectionFactory().getEntityManager();
        EmpresaRepository empresaRepository = new EmpresaRepository(entityManager);
        ModuloRepository moduloRepository = new ModuloRepository(entityManager);
        TrilhaRepository trilhaRepository = new TrilhaRepository(entityManager);
        TrabalhadorRepository trabalhadorRepository = new TrabalhadorRepository(entityManager);
        UsuarioRepository usuarioRepository = new UsuarioRepository(entityManager);
        FuncaoRepository funcaoRepository = new FuncaoRepository(entityManager);
        SetorRepository setorRepository = new SetorRepository(entityManager);
        AvaliacaoRepository avaliacaoRepository = new AvaliacaoRepository(entityManager);
        HistoricoFuncaoRepository historicoFuncaoRepository = new HistoricoFuncaoRepository(entityManager);
        EmpresaService empresaService = new EmpresaService(entityManager);
        ModuloService moduloService = new ModuloService(entityManager);
        TrabalhadorService trabalhadorService = new TrabalhadorService(entityManager);
        TrilhaService trilhaService = new TrilhaService(entityManager);
        UsuarioService usuarioService = new UsuarioService(entityManager);


        var usuario = UsuarioFixture.get().withRandomData().build();
        var empresaRequest = EmpresaRequestRepresentationFixture.get().withRandomData().build();
//        empresaService.cadastrarEmpresa(empresaRequest, usuario);
//        var empresa = empresaService.buscarEmpresa(empresaRequest.getCnpj());
//        System.out.println(empresa);
//        empresaService.deletarEmpresaPorCnpj(empresa.getCnpj());
        System.out.println(empresaService.buscarTodas());

    }
}
