package br.caelum.argentum.testes;

import br.caelum.argentum.Candle;
import br.caelum.argentum.Negocio;
import br.caelum.argentum.reader.CandleFactory;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestaCandleFactory {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();//Pegando a Data/Hora Atual

        Negocio negocio1 = new Negocio("40.50", 100, hoje);
        Negocio negocio2 = new Negocio("45.00", 100, hoje);
        Negocio negocio3 = new Negocio("39.80", 100, hoje);
        Negocio negocio4 = new Negocio("42.30", 100, hoje);
        //Outro jeito de se criar uma lista além do new ArrayList<>() e depois dar o add
        List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3, negocio4);//
        //
        CandleFactory fabrica = new CandleFactory();
        Candle candle = fabrica.constroiCandleParaData(hoje, negocios);

        System.out.println(candle);

        System.out.println(candle.getAbertura());
        System.out.println(candle.getFechamento());
        System.out.println(candle.getMinimo());
        System.out.println(candle.getMaximo());
        System.out.println(candle.getVolume());
    }
}
