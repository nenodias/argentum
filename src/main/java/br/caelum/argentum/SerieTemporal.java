/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum;

import java.util.List;

/**
 *
 * @author nenodias
 */
public class SerieTemporal {
    private final List<Candle> candles;
    
    public SerieTemporal(List<Candle> candles){
        if(candles == null){
            throw new IllegalArgumentException("Lista de Candles não pode ser nulla");
        }
        this.candles = candles;
    }

    public Candle getCandle(int i) {
        return candles.get(i);
    }
    
    public int getTotal(){
        return this.candles.size();
    }

}
