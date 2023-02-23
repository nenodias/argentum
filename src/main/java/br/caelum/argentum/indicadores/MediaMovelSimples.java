package br.caelum.argentum.indicadores;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import br.caelum.argentum.Indicador;
import br.caelum.argentum.SerieTemporal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MediaMovelSimples implements Indicador {

    private static final Logger LOGGER = LogManager.getRootLogger();

    private static final BigDecimal constante = new BigDecimal("3");

    private final Indicador outroIndicador;

    public MediaMovelSimples(Indicador outroIndicador) {
        super();
        this.outroIndicador = outroIndicador;
    }

    @Override
    public BigDecimal calcula(int posicao, SerieTemporal serie) {
        BigDecimal soma = new BigDecimal(BigInteger.ZERO, 2, MathContext.DECIMAL32);
        for (int i = posicao - 2; i <= posicao; i++) {
            LOGGER.info("Calculando média móvel simples para a posicao: " + posicao);
            soma = soma.add(outroIndicador.calcula(i, serie));
        }
        return soma.divide(constante, MathContext.DECIMAL32);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " do " + outroIndicador.toString();
    }
}
