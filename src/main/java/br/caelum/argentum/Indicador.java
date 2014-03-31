package br.caelum.argentum;

import java.math.BigDecimal;

public interface Indicador {
	BigDecimal calcula(int posicao, SerieTemporal serie);
}
