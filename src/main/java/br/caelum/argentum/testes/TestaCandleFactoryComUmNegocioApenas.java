/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.testes;

import br.caelum.argentum.Candle;
import br.caelum.argentum.Negocio;
import br.caelum.argentum.reader.CandleFactory;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author nenodias
 */
public class TestaCandleFactoryComUmNegocioApenas {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        Negocio negocio1 = new Negocio("40.5",100,hoje);
        
        List<Negocio> negocios = Arrays.asList(negocio1);
        
        CandleFactory factory = new CandleFactory();
        Candle candle = factory.constroiCandleParaData(hoje, negocios);
        
        System.out.println(candle.getAbertura());
        System.out.println(candle.getFechamento());
        System.out.println(candle.getMinimo());
        System.out.println(candle.getMaximo());
        System.out.println(candle.getVolume());
        System.out.println(candle);
    }
}
