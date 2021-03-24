package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/* A classe Funcionario deve respeitar os seguintes principios:
 * 
 * 1) S - Deve ser apenas uma representacao de um Funcionario, ou seja, nao deve cuidar de regras/logicas de negocio (coesao). Dessa forma, so deveriamos mudar a classe funcionario, se a representacao de funcionario mudasse (Single Responsibility Principle)
 */
public class Funcionario {

	private DadosPessoais dados; // composicao
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dados = new DadosPessoais(nome, cpf, cargo, salario);
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		// A classe Funcionario nao sabe como eh feita a logica, a regra de reajuste do
		// salario. Quem sabe isso, eh a classe ReajusteService, que chama este metodo
		// atualizarSalario
		this.dados.setSalario(novoSalario);
		this.dataUltimoReajuste = LocalDate.now();

		/*
		 * esta classe virou um setSalario disfarcado Talvez uma alternativa seria
		 * alterar a visibilidade do método atualizarSalario da classe Funcionario para
		 * package-private: void atualizarSalario(BigDecimal novoSalario) { codigo... }
		 * E alterar a estrutura de pacotes da aplicação, movendo a classe
		 * ReajusteService para o mesmo pacote da classe Funcionario, para que ela
		 * consiga enxergar o método atualizarSalario. Assim dá para garantir que apenas
		 * as classe dentro desse pacote enxerguem o método atualizarSalario, impedindo
		 * que de fora ele seja chamado
		 * 
		 */
	}

	public DadosPessoais getDados() {
		return dados;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public void promover(Cargo novoCargo) {
		this.dados.setCargo(novoCargo);
	}

}
