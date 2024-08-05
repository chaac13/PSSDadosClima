package services;

import model.ArquivoXmlApi;
import model.ArquivoJsonApi;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GerenciadorDeSalvarArquivoService {

    ArrayList<ISalvarLogAdapter> salvarArquivos;

    public GerenciadorDeSalvarArquivoService() {
        this.salvarArquivos = new ArrayList<>();
        this.salvarArquivos.add(new JsonAdapter(new ArquivoJsonApi()));
        this.salvarArquivos.add(new XmlAdapter(new ArquivoXmlApi()));
    }
    
    public void processarLog(String tipoArquivo, LocalDate data, LocalTime hora, String tipoOperacao){
        for(ISalvarLogAdapter formaSalvar : salvarArquivos){
            if(formaSalvar.verificaTipoDeArquivo(tipoArquivo)){
                formaSalvar.salvar(data, hora, tipoOperacao);
                break;
            }
        }   
    }
}
