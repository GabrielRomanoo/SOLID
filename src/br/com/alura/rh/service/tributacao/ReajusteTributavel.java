package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;

public interface ReajusteTributavel extends Reajuste { //herda de reajuste, é filho de reajuste, pq ReajusteTributavel eh um tipo de reajuste
	
	BigDecimal valorImpostoDeRenda();
}
