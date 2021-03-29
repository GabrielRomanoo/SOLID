package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements ReajusteTributavel, Reajuste { //nao precisaria escrever Reajuste nesta limpa, pq o ReajusteTributavel extends do Reajuste

	private BigDecimal valor;
	private LocalDate data;

	public Promocao(BigDecimal valor) {
		this.valor = valor;
		this.data = LocalDate.now();
	}

	@Override
	public BigDecimal valor() {
		return this.valor;
	}

	@Override
	public LocalDate data() {
		return this.data;
	}

	@Override
	public BigDecimal valorImpostoDeRenda() {
		return this.valor.multiply(new BigDecimal("0.1"));
	}
}
