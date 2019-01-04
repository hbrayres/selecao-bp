package br.com.hbrayres.jurosapi.domain.enums;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;

import lombok.Getter;

public enum Risco {

	A(ZERO), B(TEN), C(BigDecimal.valueOf(20L));
	
	@Getter
	private BigDecimal taxaJuros;
	
	private Risco(final BigDecimal taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
}
