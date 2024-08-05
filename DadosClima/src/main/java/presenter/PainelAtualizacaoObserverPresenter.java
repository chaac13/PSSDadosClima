package presenter;

import view.UltimaAtualizacaoDoTempoView;

import javax.swing.JInternalFrame;
import model.DadoClima;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JLabel;

public class PainelAtualizacaoObserverPresenter implements IPainel {

    final UltimaAtualizacaoDoTempoView atualizaTempoTela;
    final private ArrayList<DadoClima> dadosClima;
    private boolean visible;

    public PainelAtualizacaoObserverPresenter() {
        this.atualizaTempoTela = new UltimaAtualizacaoDoTempoView();
        this.atualizaTempoTela.setLocation(0, 320);
        this.dadosClima = new ArrayList<>();
        this.visible = false;

    }

    @Override
    public void atualizar(DadoClima dadoClima) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (int i = 0; i < this.dadosClima.size(); i++) {
            if (dadoClima.equals(this.dadosClima.get(i))) {
                this.dadosClima.remove(dadoClima);
                return;
            }
        }
        this.dadosClima.add(dadoClima);
            

        JLabel data = atualizaTempoTela.getLabelData();
        JLabel temp = atualizaTempoTela.getLabelTemperatura();
        JLabel pressao = atualizaTempoTela.getLabelPressao();
        JLabel umidade = atualizaTempoTela.getLabelUmidade();

        data.setText(dadoClima.data().format(formatter));
        temp.setText(Float.toString(dadoClima.temperatura()));
        pressao.setText(Float.toString(dadoClima.pressao()));
        umidade.setText(Float.toString(dadoClima.umidade()));


    }

    @Override
    public JInternalFrame getView() {
        return this.atualizaTempoTela;
    }
    @Override
    public void setVisible(boolean visiblidade) {
        this.atualizaTempoTela.setVisible(visiblidade);
        this.visible = visiblidade;
    }
    
    @Override
    public boolean getvisibilidade() {
        return this.visible;
    }

}
