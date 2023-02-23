package br.caelum.argentum.indicadores;

import java.math.BigDecimal;

import br.caelum.argentum.Indicador;
import br.caelum.argentum.SerieTemporal;

public class IndicadorFechamento implements Indicador {

    @Override
    public BigDecimal calcula(int posicao, SerieTemporal serie) {
        return serie.getCandle(posicao).getFechamento();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
