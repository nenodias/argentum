package br.caelum.argentum.grafico;

import br.caelum.argentum.Indicador;
import br.caelum.argentum.SerieTemporal;
import br.caelum.argentum.indicadores.MediaMovelPonderada;
import br.caelum.argentum.indicadores.MediaMovelSimples;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

public class GeradorDeGrafico {

    private static final int LARGURA = 500;
    private static final int ALTURA = 350;
    private SerieTemporal serie;
    private int comeco;
    private int fim;

    private DefaultCategoryDataset dados;
    private JFreeChart grafico;

    public GeradorDeGrafico(SerieTemporal serie, int comeco, int fim) {
        super();
        this.serie = serie;
        this.comeco = comeco;
        this.fim = fim;
        this.dados = new DefaultCategoryDataset();
        this.grafico = ChartFactory.createLineChart("Indicadores", "Dias", "Valores", dados, PlotOrientation.VERTICAL, true, true, false);
    }

    public void plotaIndicador(Indicador indice) {
        for (int i = comeco; i <= fim; i++) {
            BigDecimal valor = indice.calcula(i, serie);
            dados.addValue(valor, indice.toString(), Integer.valueOf(i));
        }
    }

    public void plotaMediaMovelSimples(Indicador indicador) {
        plotaIndicador(new MediaMovelSimples(indicador));
    }

    public void plotaMediaMovelPonderada(Indicador indicador) {
        plotaIndicador(new MediaMovelPonderada(indicador));
    }

    public void salvar(OutputStream out) throws IOException {
        ChartUtils.writeChartAsPNG(out, grafico, LARGURA, ALTURA);
    }

    public JPanel getPanel() {
        return new ChartPanel(grafico);
    }
}
