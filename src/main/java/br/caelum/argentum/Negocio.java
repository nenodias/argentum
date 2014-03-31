/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author nenodias
 */
@XStreamAlias("negocio")
public final class Negocio implements Comparable<Negocio>{
    private final BigDecimal preco;
    private final int quantidade;
    private final Calendar data;

    public Negocio(String preco, int quantidade, Calendar data) {
        if(data == null) {
            throw new IllegalArgumentException("A Data não pode ser nula");
        }
        this.preco = new BigDecimal(preco);
        this.quantidade = quantidade;
        this.data = data;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Calendar getData() {
        return (Calendar) data.clone();
    }
    
    public BigDecimal getVolume(){
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }
    
    public boolean isMesmoDia(Calendar outra){
        return data.get(Calendar.DATE) == outra.get(Calendar.DATE) &&
               data.get(Calendar.MONTH) == outra.get(Calendar.MONTH) &&
               data.get(Calendar.YEAR) == outra.get(Calendar.YEAR);
    }

    @Override
    public int compareTo(Negocio t) {
        //Ordena pela Data mais antiga
        //Contrário do próprio Calendar
        int retorno = 0;
        if(this.isMesmoDia(t.getData())) {
            retorno = 0;
        }else if(data.getTimeInMillis() > t.getData().getTimeInMillis()){
            retorno = 1;
        }else if(data.getTimeInMillis() < t.getData().getTimeInMillis()){
            retorno = -1;
        }
        return retorno;
    }
}
