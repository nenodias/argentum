package br.caelum.argentum.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import br.caelum.argentum.Indicador;
import br.caelum.argentum.indicadores.IndicadorAbertura;
import br.caelum.argentum.indicadores.IndicadorFechamento;
import br.caelum.argentum.indicadores.MediaMovelPonderada;
import br.caelum.argentum.indicadores.MediaMovelSimples;

public class MenuIndicadores {

    private JMenuBar menuBar;
    private HashMap<JCheckBoxMenuItem, Indicador> indicadoresNoMenu;

    public MenuIndicadores() {
        List<Indicador> indicadores = new ArrayList<Indicador>();
        indicadores.add(new IndicadorAbertura());
        indicadores.add(new IndicadorFechamento());
        indicadores.add(new MediaMovelPonderada(new IndicadorAbertura()));
        indicadores.add(new MediaMovelPonderada(new IndicadorFechamento()));
        indicadores.add(new MediaMovelSimples(new IndicadorAbertura()));
        indicadores.add(new MediaMovelSimples(new IndicadorFechamento()));

        menuBar = new JMenuBar();
        JMenu menuIndicadores = new JMenu("Indicadores");
        menuBar.add(menuIndicadores);

        indicadoresNoMenu = new HashMap<JCheckBoxMenuItem, Indicador>();

        for (Indicador indicador : indicadores) {
            JCheckBoxMenuItem opcaoIndicador = new JCheckBoxMenuItem(indicador.toString(), true);
            menuIndicadores.add(opcaoIndicador);
            indicadoresNoMenu.put(opcaoIndicador, indicador);
        }

    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public HashMap<JCheckBoxMenuItem, Indicador> getIndicadoresNoMenu() {
        return indicadoresNoMenu;
    }

    public void setIndicadoresNoMenu(
            HashMap<JCheckBoxMenuItem, Indicador> indicadoresNoMenu) {
        this.indicadoresNoMenu = indicadoresNoMenu;
    }

    public List<Indicador> getIndicadoresSelecionados() {
        List<Indicador> retorno = new ArrayList<Indicador>();
        for (JCheckBoxMenuItem menuCheckBox : indicadoresNoMenu.keySet()) {
            if (menuCheckBox.isSelected()) {
                retorno.add(indicadoresNoMenu.get(menuCheckBox));
            }
        }
        return retorno;
    }

}
