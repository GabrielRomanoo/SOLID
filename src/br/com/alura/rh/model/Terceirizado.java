package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Terceirizado {

	private DadosPessoais dados; // composicao
	private String empresa;

	private Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario, String empresa) {
		this.dados = new DadosPessoais(nome, cpf, cargo, salario);
		this.empresa = empresa;
	}

	public DadosPessoais getDados() {
		return dados;
	}

	public String getEmpresa() {
		return empresa;
	}

}
