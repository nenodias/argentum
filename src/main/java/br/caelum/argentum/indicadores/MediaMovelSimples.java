/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.indicadores;

import br.caelum.argentum.Candle;
import br.caelum.argentum.SerieTemporal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 *
 * @author nenodias
 */
public class MediaMovelSimples {
    private static final BigDecimal constante = new BigDecimal("3");
    
    public BigDecimal calcula (int posicao, SerieTemporal serie){
        BigDecimal soma = new BigDecimal(BigInteger.ZERO, 2, MathContext.DECIMAL32);
        for (int i = posicao - 2; i <= posicao; i++) {
            soma = soma.add( serie.getCandle(i).getFechamento() );
        }
        return soma.divide(constante, MathContext.DECIMAL32);
    }
}
