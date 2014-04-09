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
public class TestaCandleNegativo {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio = new Negocio("0.0", -10, hoje);
        Negocio negocio1 = new Negocio("0.0", 0, hoje);
        
        List<Negocio> negocios = Arrays.asList(negocio,negocio1);
        
        CandleFactory factory = new CandleFactory();
        Candle candle = factory.constroiCandleParaData(hoje, negocios);
        
        System.out.println(candle);
        
    }
}
