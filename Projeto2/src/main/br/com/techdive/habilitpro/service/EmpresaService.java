package main.br.com.techdive.habilitpro.service;

import main.br.com.techdive.habilitpro.domain.Empresa;
import main.br.com.techdive.habilitpro.domain.EnumEmpresa;
import main.br.com.techdive.habilitpro.domain.Usuario;
import main.br.com.techdive.habilitpro.repository.EmpresaRepository;
import main.br.com.techdive.habilitpro.representation.request.EmpresaRequestRepresentation;

import static java.util.Objects.isNull;

public class EmpresaService {

    private static final String CNPJ_REGEX = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})";

    public void cadastrarEmpresa(EmpresaRequestRepresentation request, Usuario usuario) {
        VerificaPerfilAcesso.verificaPerfilParaCadastro(usuario);
        verificaCnpj(request.getCnpj());
        request.setEnumSegmentoAtuacao(DefinirSegmentoService.definir(request.getSegmentoAtuacao()));
        request.setEnumTipoEmpresa(definirHierarquia(request.getTipoEmpresa()));

        Empresa empresa = Empresa.builder()
                .id((long) EmpresaRepository.empresas.size() + 1)
                .cnpj(request.getCnpj())
                .nome(request.getNome())
                .tipoEmpresa(request.getEnumTipoEmpresa())
                .segmentoAtuacao(request.getEnumSegmentoAtuacao())
                .nomeFiliais(request.getNomeFiliais())
                .build();
        EmpresaRepository.empresas.put(empresa.getCnpj(), empresa);

    }

    public static Empresa buscarEmpresa(String cnpj) {
        Empresa empresa = EmpresaRepository.empresas.get(cnpj);
        if(isNull(empresa)) {
            throw new RuntimeException("CNPJ não cadastrado para nenhuma empresa!");
        }
        return empresa;
    }

    public static void verificaCnpj(String cnpj) {
        if (!cnpj.matches(CNPJ_REGEX)) {
            throw new RuntimeException("CNPJ em formato inválido!");
        }
    }

    private EnumEmpresa definirHierarquia(String tipoEmpresa) {
        if (tipoEmpresa.equalsIgnoreCase(EnumEmpresa.MATRIZ.getDescription())) {
            return EnumEmpresa.MATRIZ;
        } else if (tipoEmpresa.equalsIgnoreCase(EnumEmpresa.FILIAL.getDescription())) {
            return EnumEmpresa.FILIAL;
        } else {
            throw new RuntimeException("A hierarquia da empresa inválida! Deve ser Matriz ou Filial!");
        }
    }

}
