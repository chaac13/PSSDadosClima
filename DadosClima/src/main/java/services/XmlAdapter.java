package services;

import model.ArquivoXmlApi;
import java.time.LocalDate;
import java.time.LocalTime;


public class XmlAdapter implements ISalvarLogAdapter {
    
    final private ArquivoXmlApi arquivoXml;
    
    public XmlAdapter(ArquivoXmlApi arqXmlApi){
        this.arquivoXml = arqXmlApi;
        
    }
    @Override
    public void salvar(LocalDate data, LocalTime hora, String tipoOperacao){
        this.arquivoXml.salvarLog(data, hora, tipoOperacao);     
    }
    @Override
    public boolean verificaTipoDeArquivo(String tipoArquivo){
        return tipoArquivo == "XML";
    }
    
}
