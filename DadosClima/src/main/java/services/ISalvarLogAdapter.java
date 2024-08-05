package services;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ISalvarLogAdapter {

    void salvar(LocalDate data, LocalTime hora, String tipoOperacao);
    boolean verificaTipoDeArquivo(String tipoArquivo);
}
