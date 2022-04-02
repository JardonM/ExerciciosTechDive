package service;

import model.entities.SegmentoAtuacao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefinirSegmentoService {

    private static final Logger LOG = LogManager.getLogger(DefinirSegmentoService.class);

    public static SegmentoAtuacao definir(String areaAtuacao) {
        LOG.info("Definindo segmento de atuação");
        if (areaAtuacao.equalsIgnoreCase("Alimentos e Bebidas")) {
            LOG.info("Segmento de atuação definido: Alimentos e Bebidas");
            return SegmentoAtuacao.ALIMENTOS_BEBIDAS;
        } else if (areaAtuacao.equalsIgnoreCase("Celulose e Papel")) {
            LOG.info("Segmento de atuação definido: Celulose e Papel");
            return SegmentoAtuacao.CELULOSE_PAPEL;
        } else if (areaAtuacao.equalsIgnoreCase("Equipamentos elétricos")) {
            LOG.info("Segmento de atuação definido: Equipamentos elétricos");
            return SegmentoAtuacao.EQUIPAMENTOS_ELETRICOS;
        } else if (areaAtuacao.equalsIgnoreCase("Fármacos e Equipamentos de Saúde")) {
            LOG.info("Segmento de atuação definido: Fármacos e Equipamentos de Saúde");
            return SegmentoAtuacao.FARMACO_EQUIPAMENTOS_SAUDE;
        } else if (areaAtuacao.equalsIgnoreCase("Fumo")) {
            LOG.info("Segmento de atuação definido: Fumo");
            return SegmentoAtuacao.FUMO;
        } else if (areaAtuacao.equalsIgnoreCase("Indústria Automotiva")) {
            LOG.info("Segmento de atuação definido: Indústria Automotiva");
            return SegmentoAtuacao.INDUSTRIA_AUTOMOTIVA;
        } else if (areaAtuacao.equalsIgnoreCase("Indústria Cerâmica")) {
            LOG.info("Segmento de atuação definido: Indústria Cerâmica");
            return SegmentoAtuacao.INDUSTRIA_CERAMICA;
        } else if (areaAtuacao.equalsIgnoreCase("Indústria Diversa")) {
            LOG.info("Segmento de atuação definido: Indústria Diversa");
            return SegmentoAtuacao.INDUSTRIA_DIVERSA;
        } else if (areaAtuacao.equalsIgnoreCase("Indústria Extrativa")) {
            LOG.info("Segmento de atuação definido: Indústria Extrativa");
            return SegmentoAtuacao.INDUSTRIA_EXTRATIVA;
        } else if (areaAtuacao.equalsIgnoreCase("Indústria Gráfica")) {
            LOG.info("Segmento de atuação definido: Indústria Gráfica");
            return SegmentoAtuacao.INDUSTRIA_GRAFICA;
        } else if (areaAtuacao.equalsIgnoreCase("Madeira e Móveis")) {
            LOG.info("Segmento de atuação definido: Madeira e Móveis");
            return SegmentoAtuacao.MADEIRA_MOVEIS;
        } else if (areaAtuacao.equalsIgnoreCase("Máquinas e Equipamentos")) {
            LOG.info("Segmento de atuação definido: Máquinas e Equipamentos");
            return SegmentoAtuacao.MAQUINAS_EQUIPAMENTOS;
        } else if (areaAtuacao.equalsIgnoreCase("Metalmecânica e Metalurgia")) {
            LOG.info("Segmento de atuação definido: Metalmecânica e Metalurgia");
            return SegmentoAtuacao.METALMECANICA_METALURGIA;
        } else if (areaAtuacao.equalsIgnoreCase("Óleo, Gás e Eletricidade")) {
            LOG.info("Segmento de atuação definido: Óleo, Gás e Eletricidade");
            return SegmentoAtuacao.OLEO_GAS_ELETRICIDADE;
        } else if (areaAtuacao.equalsIgnoreCase("Produtos Químicos e Plásticos")) {
            LOG.info("Segmento de atuação definido: Produtos Químicos e Plásticos");
            return SegmentoAtuacao.PRODUTOS_QUIMICOS_PLASTICOS;
        } else if (areaAtuacao.equalsIgnoreCase("Saneamento Básico")) {
            LOG.info("Segmento de atuação definido: Saneamento Básico");
            return SegmentoAtuacao.SANEAMENTO_BASICO;
        } else if (areaAtuacao.equalsIgnoreCase("TIC")) {
            LOG.info("Segmento de atuação definido: TIC");
            return SegmentoAtuacao.TIC;
        } else if (areaAtuacao.equalsIgnoreCase("Têxtil, Confecção, Couro e Calçados")) {
            LOG.info("Segmento de atuação definido: Têxtil, Confecção, Couro e Calçados");
            return SegmentoAtuacao.TEXTIL_CONFECCAO_COURO_CALCADOS;
        } else if (areaAtuacao.equalsIgnoreCase("Construção")) {
            LOG.info("Segmento de atuação definido: Construção");
            return SegmentoAtuacao.CONSTRUCAO;
        } else {
            LOG.error("Segmento de atuação não encontrado");
            throw new RuntimeException("Segmento de Atuação não encontrado!");
        }
    }

}
