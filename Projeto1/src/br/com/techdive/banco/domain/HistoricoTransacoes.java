package br.com.techdive.banco.domain;

import java.time.LocalDateTime;

public class HistoricoTransacoes {

    private int contaOrigem;
    private int contaDestino;
    private TipoTransacao tipoTransacao;
    private double valor;
    private LocalDateTime horaTransacao;

    public HistoricoTransacoes(TipoTransacao tipoTransacao,int contaOrigem, int contaDestino, double valor, LocalDateTime horaTransacao) {
        this.tipoTransacao = tipoTransacao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.horaTransacao = horaTransacao;
    }

    public HistoricoTransacoes(TipoTransacao tipoTransacao, int contaOrigem, double valor, LocalDateTime horaTransacao) {
        this.contaOrigem = contaOrigem;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.horaTransacao = horaTransacao;
    }

    public HistoricoTransacoes(TipoTransacao tipoTransacao, int contaOrigem, LocalDateTime horaTransacao) {
        this.contaOrigem = contaOrigem;
        this.tipoTransacao = tipoTransacao;
        this.horaTransacao = horaTransacao;
    }

    @Override
    public String toString() {
        return "HistoricoTransacoes{" +
                "contaOrigem = " + contaOrigem +
                ", contaDestino = " + contaDestino +
                ", tipoTransacao = " + tipoTransacao +
                ", valor = " + valor +
                ", horaTransacao = " + horaTransacao +
                '}';
    }
}
