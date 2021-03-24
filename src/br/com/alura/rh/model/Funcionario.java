package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/* A classe Funcionario deve respeitar os seguintes principios:
 * 
 * 1) S - Deve ser apenas uma representacao de um Funcionario, ou seja, nao deve cuidar de regras/logicas de negocio (coesao). Dessa forma, so deveriamos mudar a classe funcionario, se a representacao de funcionario mudasse (Single Responsibility Principle)
 */
public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		// A classe Funcionario nao sabe como eh feita a logica, a regra de reajuste do salario. Quem sabe isso, eh a classe ReajusteService, que chama este metodo atualizarSalario
		this.salario = novoSalario;
		this.dataUltimoReajuste = LocalDate.now();
		
		/* esta classe virou um setSalario disfarcado
		 * Talvez uma alternativa seria alterar a visibilidade do método atualizarSalario da classe Funcionario para package-private:
		 * 	void atualizarSalario(BigDecimal novoSalario) {
    			codigo...
    		}
    	 * E alterar a estrutura de pacotes da aplicação, movendo a classe ReajusteService para o mesmo pacote da classe Funcionario, para que ela consiga enxergar o método atualizarSalario.
    	 * Assim dá para garantir que apenas as classe dentro desse pacote enxerguem o método atualizarSalario, impedindo que de fora ele seja chamado
		 * 
		 */
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public void promover(Cargo novoCargo) {
		this.cargo = novoCargo;
	}

}
