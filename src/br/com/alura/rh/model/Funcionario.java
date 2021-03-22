package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/* A classe Funcionario deve respeitar os seguintes principios:
 * 
 * 1- Deve ser apenas uma representacao de um Funcionario, ou seja, nao deve cuidar de regras/logicas de negocio (coesao)
 * */
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

}
