package br.caelum.argentum.testes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JFrame;

import br.caelum.argentum.SerieTemporal;
import br.caelum.argentum.grafico.GeradorDeGrafico;
import br.caelum.argentum.indicadores.IndicadorFechamento;
import br.caelum.argentum.reader.GeradorDeSerie;

public class TesteGeraGrafico {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        SerieTemporal serie = GeradorDeSerie.criaSerie(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("4"), new BigDecimal("5"), new BigDecimal("6"), new BigDecimal("7"), new BigDecimal("8"), new BigDecimal("8"), new BigDecimal("9"), new BigDecimal("9"), new BigDecimal("4"), new BigDecimal("3"), new BigDecimal("2"), new BigDecimal("2"), new BigDecimal("2"), new BigDecimal("2"));
        GeradorDeGrafico gerador = new GeradorDeGrafico(serie, 2, 15);
        gerador.plotaMediaMovelPonderada(new IndicadorFechamento());
        gerador.plotaMediaMovelSimples(new IndicadorFechamento());
        gerador.salvar(new FileOutputStream("saida.png"));

        JFrame frame = new JFrame("Minha Janela");
        frame.add(gerador.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
