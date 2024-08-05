package model;


import presenter.IPainel;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class EstacaoClimatica {
    
   final private List<IPainel> paineis;

   public EstacaoClimatica() {
       paineis = new ArrayList<>();
   }

   public void adicionarPainel(IPainel painel) {
       paineis.add(painel);
   }

   public void removerPainel(IPainel painel) {
       paineis.remove(painel);
   }

   public void atualizarMedicoes(float temperatura, float umidade, float pressao, LocalDate data) {
       DadoClima dadoClima = new DadoClima(temperatura, umidade, pressao, data);
       notificar(dadoClima);
   }
   
   private void notificar(DadoClima dadoClima) {
       for (IPainel painel : paineis) {
           painel.atualizar(dadoClima);
       }
   }

}
