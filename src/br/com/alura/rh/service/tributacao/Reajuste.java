package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste { //para usar o polimorfismo e ter varios tipos de reajuste

	BigDecimal valor();
	LocalDate data();
}
