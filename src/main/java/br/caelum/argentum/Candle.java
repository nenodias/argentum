package br.caelum.argentum;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candle {

    private final BigDecimal abertura;
    private final BigDecimal fechamento;
    private final BigDecimal minimo;
    private final BigDecimal maximo;
    private final BigDecimal volume;
    private final Calendar data;

    public Candle(BigDecimal abertura, BigDecimal fechamento, BigDecimal minimo, BigDecimal maximo, BigDecimal volume, Calendar data) {
        testesCriacao(abertura, fechamento, minimo, maximo, volume, data);
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    public BigDecimal getAbertura() {
        return abertura;
    }

    public BigDecimal getFechamento() {
        return fechamento;
    }

    public BigDecimal getMinimo() {
        return minimo;
    }

    public BigDecimal getMaximo() {
        return maximo;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public Calendar getData() {
        return (Calendar) data.clone();
    }

    public boolean isAlta() {
        return ((abertura.compareTo(fechamento) == 1 || abertura.compareTo(fechamento) == 0 ? true : false));
    }

    public boolean isBaixa() {
        return ((abertura.compareTo(fechamento) == -1 ? true : false));
    }

    @Override
    public String toString() {
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/YYYY");
        return "[" + "Abertura " + abertura + ", Fechamento " + fechamento + ", Mínimo " + minimo + ", Máximo " + maximo + ", Volume " + volume + ", Data " + dt.format(data.getTime()) + ']';
    }

    private void testesCriacao(BigDecimal abertura1, BigDecimal fechamento1, BigDecimal minimo1, BigDecimal maximo1, BigDecimal volume1, Calendar data1) {
        if (maximo1.compareTo(minimo1) == -1) {
            throw new IllegalArgumentException("Valor máximo não deve ser menor que o mínimo");
        }
        if (data1 == null) {
            throw new IllegalArgumentException("Data não pode ser nula");
        }
        if (abertura1.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Abertura com valor negativo");
        }
        if (fechamento1.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Fechamento com valor negativo");
        }
        if (volume1.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Volume com valor negativo");
        }
        if (minimo1.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Mínimo com valor negativo");
        }
        if (maximo1.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Maximo com valor negativo");
        }
    }
}
