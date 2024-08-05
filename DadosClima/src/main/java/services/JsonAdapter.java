package services;

import model.ArquivoJsonApi;
import java.time.LocalDate;
import java.time.LocalTime;


public class JsonAdapter implements ISalvarLogAdapter {
    
    final private ArquivoJsonApi arquivoJson;
    
    public JsonAdapter(ArquivoJsonApi arqJsonApi){
        this.arquivoJson = arqJsonApi;
        
    }
    @Override
    public void salvar(LocalDate data, LocalTime hora, String tipoOperacao){
        this.arquivoJson.salvarLog(data, hora, tipoOperacao);     
    }
    
    @Override
    public boolean verificaTipoDeArquivo(String tipoArquivo){
        return tipoArquivo == "JSON";
    }
    
}
