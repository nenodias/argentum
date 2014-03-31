/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.indicadores;

import java.math.BigDecimal;
import java.math.MathContext;

import br.caelum.argentum.Indicador;
import br.caelum.argentum.SerieTemporal;

/**
 *
 * @author nenodias
 */
public class MediaMovelPonderada implements Indicador {
    BigDecimal constante = new BigDecimal("6", MathContext.DECIMAL32);
    
    @Override
    public BigDecimal calcula(int posicao, SerieTemporal serie){
//        Lembrar que o BigDecimal é imutável TO DO
        BigDecimal aux = new BigDecimal("1", MathContext.DECIMAL32);
        BigDecimal soma = new BigDecimal("0", MathContext.DECIMAL32);
        for (int i = posicao -2; i <= posicao; i++) {
            soma = soma.add( aux.multiply(serie.getCandle(i).getFechamento()) );
            aux = aux.add(BigDecimal.ONE, MathContext.DECIMAL32);
        }
        return soma.divide(constante, MathContext.DECIMAL32);
    }
    
    @Override
    public String toString() {
    	return this.getClass().getSimpleName();
    }
}
