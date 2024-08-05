
package presenter;

import javax.swing.JInternalFrame;
import model.DadoClima;

public interface IPainel {
    
    void atualizar(DadoClima dadoClima);
    JInternalFrame getView();
    void setVisible(boolean visiblidade);
    boolean getvisibilidade();
    
}
