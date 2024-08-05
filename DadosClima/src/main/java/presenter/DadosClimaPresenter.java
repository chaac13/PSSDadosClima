package presenter;

import javax.swing.JFrame;
import model.EstacaoClimatica;
import view.DadosClimaView;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class DadosClimaPresenter {

    final DadosClimaView telaPrincipal;
    final private DadosDoTempoPresenter dadosTempo;
    final private IPainel atualizaTempoObserver;
    final private IPainel dadosMediosObserver;
    final private IPainel registrosObserver;
    final private IPainel telaGrafico;
    final private IPainel configuraTela;

    public DadosClimaPresenter() {

        this.telaPrincipal = new DadosClimaView();
        this.telaPrincipal.setLocationRelativeTo(null);
        this.telaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);

        EstacaoClimatica estacao = new EstacaoClimatica();

        atualizaTempoObserver = new PainelAtualizacaoObserverPresenter();
        dadosMediosObserver = new DadosMediosObserverPresenter(this.telaPrincipal.getLabelQuantideRegistro());
        registrosObserver = new RegistrosObserverPresenter(estacao);
        telaGrafico = new MaximasEMinimasObserverPresenter();
        configuraTela = new ConfiguracaoObserverPresenter();

        
        estacao.adicionarPainel(atualizaTempoObserver);
        estacao.adicionarPainel(dadosMediosObserver);
        estacao.adicionarPainel(registrosObserver);
        estacao.adicionarPainel(telaGrafico);
        estacao.adicionarPainel(configuraTela);

        this.dadosTempo = new DadosDoTempoPresenter(estacao);

        this.mostrarTodasTelas();
        this.gerenciaTelaDeConfiguracao();

    }

    private void mostrarTodasTelas() {

        JDesktopPane desktopPainel = telaPrincipal.getDesktopPanel();

        JInternalFrame dadosClima = dadosTempo.getView();
        JInternalFrame ultimaAtualizacao = atualizaTempoObserver.getView();
        JInternalFrame mediaDados = dadosMediosObserver.getView();
        JInternalFrame registros = registrosObserver.getView();
        JInternalFrame graficoTela = telaGrafico.getView();
        JInternalFrame configuracoesTela = configuraTela.getView();

        desktopPainel.add(dadosClima);
        desktopPainel.add(ultimaAtualizacao);
        desktopPainel.add(mediaDados);
        desktopPainel.add(registros);
        desktopPainel.add(graficoTela);
        desktopPainel.add(configuracoesTela);
    }

    private void gerenciaTelaDeConfiguracao() {
        JMenu menuItem = telaPrincipal.getItemMenuConfigura();

        menuItem.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                configuraTela.setVisible(!configuraTela.getvisibilidade());
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {
             
            }
        });
    }

}
