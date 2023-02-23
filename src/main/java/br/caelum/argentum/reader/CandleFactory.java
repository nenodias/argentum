package br.caelum.argentum.reader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import br.caelum.argentum.Candle;
import br.caelum.argentum.Negocio;


public class CandleFactory {

    public Candle constroiCandleParaData(Calendar data, List<Negocio> negocios) {
        BigDecimal maximo = (negocios.isEmpty() ? BigDecimal.ZERO : new BigDecimal(Double.MIN_VALUE));
        BigDecimal minimo = (negocios.isEmpty() ? BigDecimal.ZERO : new BigDecimal(Double.MAX_VALUE));
        BigDecimal volume = BigDecimal.ZERO;

        //For
        for (Negocio negocio : negocios) {
            volume = volume.add(negocio.getVolume());

            if (negocio.getPreco().compareTo(maximo) == 1) {
                maximo = negocio.getPreco();
            }
            if (negocio.getPreco().compareTo(minimo) == -1) {
                minimo = negocio.getPreco();
            }
        }

        BigDecimal abertura = (negocios.isEmpty() ? BigDecimal.ZERO : negocios.get(0).getPreco());
        BigDecimal fechamento = (negocios.isEmpty() ? BigDecimal.ZERO : negocios.get(negocios.size() - 1).getPreco());

        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }

    public List<Candle> constroiCandles(List<Negocio> todosNegocios) {
        Collections.sort(todosNegocios);
        List<Candle> candles = new ArrayList<>();

        List<Negocio> negociosDoDia = new ArrayList<>();
        Calendar dataAtual = todosNegocios.get(0).getData();

        for (Negocio negocio : todosNegocios) {
            //Se não for mesmo dia, fecha as candles e reinicia as variáveis
            if (!negocio.isMesmoDia(dataAtual)) {
                Candle candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
                candles.add(candleDoDia);
                negociosDoDia = new ArrayList<>();
                dataAtual = negocio.getData();
            }
            negociosDoDia.add(negocio);
        }
        //Gera o último Candle que é da mesma data que a dataAtual
        candles.add(constroiCandleParaData(dataAtual, negociosDoDia));
        return candles;
    }


}
