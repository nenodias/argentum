/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.indicadores;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import br.caelum.argentum.Indicador;
import br.caelum.argentum.SerieTemporal;

/**
 *
 * @author nenodias
 */
public class MediaMovelSimples implements Indicador{
    
	private static final BigDecimal constante = new BigDecimal("3");
	
	private final Indicador outroIndicador;
    
    public MediaMovelSimples(Indicador outroIndicador) {
		super();
		this.outroIndicador = outroIndicador;
	}

	@Override
    public BigDecimal calcula (int posicao, SerieTemporal serie){
        BigDecimal soma = new BigDecimal(BigInteger.ZERO, 2, MathContext.DECIMAL32);
        for (int i = posicao - 2; i <= posicao; i++) {
            soma = soma.add( outroIndicador.calcula(i, serie) );
        }
        return soma.divide(constante, MathContext.DECIMAL32);
    }
    
    @Override
    public String toString() {
    	return this.getClass().getSimpleName()+" do "+outroIndicador.toString();
    }
}
