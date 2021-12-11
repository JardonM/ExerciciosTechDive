package br.com.jardon.domain;

public class ContaCorrenteVip extends ContaCorrente{

    public ContaCorrenteVip(int idConta, double saldoConta) {
        super(idConta, saldoConta);
        this.setTaxaSaque(1.5);
    }

}
