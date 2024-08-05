package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.DadoClima;

public class MaximasEMinimasService {

    public Map<String, Float> calculaMaximas(ArrayList<DadoClima> dadosClima) {

        Map<String, Float> maximas = new HashMap<>();

        float zero = 0;
        maximas.put("TemperaturaMaxima", zero);
        maximas.put("PressaoMaxima", zero);
        maximas.put("UmidadeMaxima", zero);

        for (DadoClima dado : dadosClima) {
            if (dado.temperatura() > maximas.get("TemperaturaMaxima")) {
                maximas.put("TemperaturaMaxima", dado.temperatura());

            }
            if (dado.pressao() > maximas.get("PressaoMaxima")) {
                maximas.put("PressaoMaxima", dado.pressao());

            }
            if (dado.umidade() > maximas.get("UmidadeMaxima")) {
                maximas.put("UmidadeMaxima", dado.umidade());
            }

        }
        return maximas;
    }

    public Map<String, Float> calculaMinimas(ArrayList<DadoClima> dadosClima) {

        Map<String, Float> minimas = new HashMap<>();

        minimas.put("TemperaturaMinima", dadosClima.get(0).temperatura());
        minimas.put("PressaoMinima", dadosClima.get(0).pressao());
        minimas.put("UmidadeMinima", dadosClima.get(0).umidade());

        for (DadoClima dado : dadosClima) {

            if (dado.temperatura() < minimas.get("TemperaturaMinima")) {
                minimas.put("TemperaturaMinima", dado.temperatura());
            }
            if (dado.pressao() < minimas.get("PressaoMinima")) {
                minimas.put("PressaoMinima", dado.pressao());
            }
            if (dado.umidade() < minimas.get("UmidadeMinima")) {
                minimas.put("UmidadeMinima", dado.umidade());

            }
        }
        return minimas;
    }
    
}
