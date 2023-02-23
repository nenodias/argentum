/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.reader;

import java.math.BigDecimal;
import java.util.Calendar;

import br.caelum.argentum.Candle;

public class CandleBuilder {
    private BigDecimal abertura;
    private BigDecimal fechamento;
    private BigDecimal minimo;
    private BigDecimal maximo;
    private BigDecimal volume;
    private Calendar data;
    private Boolean[] metodos;
    //Dessa forma o objeto vai sendo construído passo-a-passo

    public CandleBuilder() {
        metodos = new Boolean[6];
        for (int i = 0; i < metodos.length; i++) {//Zerando os Booleans
            metodos[i] = false;
        }
    }

    public CandleBuilder comAbertura(BigDecimal abertura) {
        this.abertura = abertura;
        metodos[0] = true;
        return this;
    }

    public CandleBuilder comFechamento(BigDecimal fechamento) {
        this.fechamento = fechamento;
        metodos[1] = true;
        return this;
    }

    public CandleBuilder comMinimo(BigDecimal minimo) {
        this.minimo = minimo;
        metodos[2] = true;
        return this;
    }

    public CandleBuilder comMaximo(BigDecimal maximo) {
        this.maximo = maximo;
        metodos[3] = true;
        return this;
    }

    public CandleBuilder comVolume(BigDecimal volume) {
        this.volume = volume;
        metodos[4] = true;
        return this;
    }

    public CandleBuilder comData(Calendar data) {
        this.data = data;
        metodos[5] = true;
        return this;
    }

    public Candle geraCandle() {
        if (!testaMetodos()) {
            throw new IllegalArgumentException("Não completou todas as etapas do builder");
        }
        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }

    private Boolean testaMetodos() {
        for (Boolean boolean1 : metodos) {
            if (boolean1.equals(false)) {
                return false;
            }
        }
        return true;
    }

}
