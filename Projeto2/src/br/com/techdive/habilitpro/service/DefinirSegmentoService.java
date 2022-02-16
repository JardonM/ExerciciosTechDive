package br.com.techdive.habilitpro.service;

import br.com.techdive.habilitpro.domain.SegmentoAtuacao;

public class DefinirSegmentoService {

    public static SegmentoAtuacao definir(String areaAtuacao) {
        if(areaAtuacao.equalsIgnoreCase("Alimentos e Bebidas")) {
            return SegmentoAtuacao.ALIMENTOS_BEBIDAS;
        } else if(areaAtuacao.equalsIgnoreCase("Celulose e Papel")) {
            return SegmentoAtuacao.CELULOSE_PAPEL;
        } else if(areaAtuacao.equalsIgnoreCase("Equipamentos elétricos")) {
            return SegmentoAtuacao.EQUIPAMENTOS_ELETRICOS;
        }else if(areaAtuacao.equalsIgnoreCase("Fármacos e Equipamentos de Saúde")) {
            return SegmentoAtuacao.FARMACO_EQUIPAMENTOS_SAUDE;
        }else if(areaAtuacao.equalsIgnoreCase("Fumo")) {
            return SegmentoAtuacao.FUMO;
        }else if(areaAtuacao.equalsIgnoreCase("Indústria Automotiva")) {
            return SegmentoAtuacao.INDUSTRIA_AUTOMOTIVA;
        }else if(areaAtuacao.equalsIgnoreCase("Indústria Cerâmica")) {
            return SegmentoAtuacao.INDUSTRIA_CERAMICA;
        }else if(areaAtuacao.equalsIgnoreCase("Indústria Diversa")) {
            return SegmentoAtuacao.INDUSTRIA_DIVERSA;
        }else if(areaAtuacao.equalsIgnoreCase("Indústria Extrativa")) {
            return SegmentoAtuacao.INDUSTRIA_EXTRATIVA;
        }else if(areaAtuacao.equalsIgnoreCase("Indústria Gráfica")) {
            return SegmentoAtuacao.INDUSTRIA_GRAFICA;
        }else if(areaAtuacao.equalsIgnoreCase("Madeira e Móveis")) {
            return SegmentoAtuacao.MADEIRA_MOVEIS;
        }else if(areaAtuacao.equalsIgnoreCase("Máquinas e Equipamentos")) {
            return SegmentoAtuacao.MAQUINAS_EQUIPAMENTOS;
        }else if(areaAtuacao.equalsIgnoreCase("Metalmecânica e Metalurgia")) {
            return SegmentoAtuacao.METALMECANICA_METALURGIA;
        }else if(areaAtuacao.equalsIgnoreCase("Óleo, Gás e Eletricidade")) {
            return SegmentoAtuacao.OLEO_GAS_ELETRICIDADE;
        }else if(areaAtuacao.equalsIgnoreCase("Produtos Químicos e Plásticos")) {
            return SegmentoAtuacao.PRODUTOS_QUIMICOS_PLASTICOS;
        }else if(areaAtuacao.equalsIgnoreCase("Saneamento Básico")) {
            return SegmentoAtuacao.SANEAMENTO_BASICO;
        }else if(areaAtuacao.equalsIgnoreCase("TIC")) {
            return SegmentoAtuacao.TIC;
        }else if(areaAtuacao.equalsIgnoreCase("Têxtil, Confecção, Couro e Calçados")) {
            return SegmentoAtuacao.TEXTIL_CONFECCAO_COURO_CALCADOS;
        } else if(areaAtuacao.equalsIgnoreCase("Construção")) {
            return SegmentoAtuacao.CONSTRUCAO;
        } else {
            throw new RuntimeException("Segmento de Atuação não encontrado!");
        }
    }

}
