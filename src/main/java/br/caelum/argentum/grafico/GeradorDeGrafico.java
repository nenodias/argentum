package br.caelum.argentum.grafico;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import br.caelum.argentum.Indicador;
import br.caelum.argentum.SerieTemporal;
import br.caelum.argentum.indicadores.IndicadorFechamento;
import br.caelum.argentum.indicadores.MediaMovelPonderada;
import br.caelum.argentum.indicadores.MediaMovelSimples;

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
	
	public void plotaIndicador(Indicador indice){
		for (int i = comeco; i <= fim; i++) {
			BigDecimal valor = indice.calcula(i, serie);
			dados.addValue(valor, indice.toString(), Integer.valueOf(i));
		}
	}
	
	public void plotaMediaMovelSimples(){
		plotaIndicador(new MediaMovelSimples());
	}
	
	public void plotaMediaMovelPonderada(){
		plotaIndicador(new MediaMovelPonderada());
	}
	
	public void plotaIndicadorFechamento(){
		plotaIndicador(new IndicadorFechamento());
	}
	
	public void salvar(OutputStream out) throws IOException{
		ChartUtilities.writeChartAsPNG(out, grafico, LARGURA, ALTURA);
	}
	
	public JPanel getPanel(){
		return new ChartPanel(grafico);
	}
}
