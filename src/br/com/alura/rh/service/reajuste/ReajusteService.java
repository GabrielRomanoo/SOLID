package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

public class ReajusteService {
	
	private List<ValidacaoReajuste> validacoes; //Usamos uma interface como referencia para que possamos apontar para qualquer objeto que implemente essa interface
	
	// A classe ReajusteService nao precisa saber quais sao as validacoes, o que cada um faz, nos recebemos elas no contrutor
	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	// Aqui fica a regra de negocio do reajuste salarial, nao deve ficar na classe funcionario
	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		//VALIDACAO (nao sabemos quais sao, recebemos ela do contrutor) - principio 'O' do SOLID
		this.validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));
		// a classe reajuste service apenas chama cada uma das validacoes, entao ela nao conhece cada uma das validacao. entao se srugir uma nova validacao, apenas devemos criar a classe dela e adicionar a lista na hora de chamar a classe ReajusteService
		
		BigDecimal salarioReajustado = funcionario.getDados().getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}
