package br.caelum.argentum.indicadores;

import java.math.BigDecimal;

import br.caelum.argentum.Indicador;
import br.caelum.argentum.SerieTemporal;

public class IndicadorAbertura implements Indicador {

    @Override
    public BigDecimal calcula(int posicao, SerieTemporal serie) {
        return serie.getCandle(posicao).getAbertura();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
