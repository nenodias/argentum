package br.caelum.argentum.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import br.caelum.argentum.Negocio;

public class FiltradorPorData {

    private Calendar dataInicial;

    public FiltradorPorData(String dataDigitada) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);//Não aceitar datas inventadas como ano que vem
            dataInicial = Calendar.getInstance();
            dataInicial.setTime(format.parse(dataDigitada));
        } catch (Exception e) {

        }
    }

    public void filtra(List<Negocio> lista) {
        if (dataInicial != null) {
            Iterator<Negocio> it = lista.iterator();
            while (it.hasNext()) {
                if (it.next().getData().before(dataInicial)) {
                    it.remove();
                }
            }
        }
    }

}
