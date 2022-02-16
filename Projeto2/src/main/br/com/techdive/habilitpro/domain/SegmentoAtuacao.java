package main.br.com.techdive.habilitpro.domain;

public enum SegmentoAtuacao {
    ALIMENTOS_BEBIDAS("Alimentos e Bebidas"),
    CELULOSE_PAPEL("Celulose e Papel"),
    CONSTRUCAO("Construção"),
    EQUIPAMENTOS_ELETRICOS("Equipamentos elétricos"),
    FARMACO_EQUIPAMENTOS_SAUDE("Fármacos e Equipamentos de Saúde"),
    FUMO("Fumo"),
    INDUSTRIA_AUTOMOTIVA("Indústria Automotiva"),
    INDUSTRIA_CERAMICA("Indústria Cerâmica"),
    INDUSTRIA_DIVERSA("Indústria Diversa"),
    INDUSTRIA_EXTRATIVA("Indústria Extrativa"),
    INDUSTRIA_GRAFICA("Indústria Gráfica"),
    MADEIRA_MOVEIS("Madeira e Móveis"),
    MAQUINAS_EQUIPAMENTOS("Máquinas e Equipamentos"),
    METALMECANICA_METALURGIA("Metalmecânica e Metalurgia"),
    OLEO_GAS_ELETRICIDADE("Óleo, Gás e Eletricidade"),
    PRODUTOS_QUIMICOS_PLASTICOS("Produtos Químicos e Plásticos"),
    SANEAMENTO_BASICO("Saneamento Básico"),
    TIC("TIC"),
    TEXTIL_CONFECCAO_COURO_CALCADOS("Têxtil, Confecção, Couro e Calçados");

    private String description;

    SegmentoAtuacao(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
