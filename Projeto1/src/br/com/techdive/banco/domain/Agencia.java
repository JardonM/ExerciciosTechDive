package br.com.techdive.banco.domain;

public enum Agencia {
    SEM_AGENCIA("000 - SEM AGENCIA"),
    FLORIANOPOLIS("001 - Florianopolis"),
    SAO_JOSE("002 - Sao Jose");

    private String agencia;

    Agencia(String agencia) {
        this.agencia = agencia;
    }

    Agencia() {
    }

    public String getAgencia() {
        return agencia;
    }
}
