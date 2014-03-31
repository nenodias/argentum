package br.caelum.argentum.reader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.caelum.argentum.Candle;
import br.caelum.argentum.SerieTemporal;

public class GeradorDeSerie {
	
	private static final BigDecimal MIL = new BigDecimal("1000");

	public static SerieTemporal criaSerie(BigDecimal ... valores){
		List<Candle>candles = new ArrayList<Candle>();
		for (BigDecimal bigDecimal : valores) {
			candles.add( new Candle(bigDecimal, bigDecimal, bigDecimal, bigDecimal, MIL, Calendar.getInstance() ) );
		}
		return new SerieTemporal(candles);
	}
}
