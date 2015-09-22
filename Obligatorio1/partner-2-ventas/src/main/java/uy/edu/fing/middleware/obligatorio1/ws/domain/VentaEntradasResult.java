package uy.edu.fing.middleware.obligatorio1.ws.domain;

import java.util.List;

/**
 * @author Farid
 */
public class VentaEntradasResult {

    Long cobroID;
    List<String> codigosEntradas;

    public Long getCobroID() {
        return cobroID;
    }

    public void setCobroID(Long cobroID) {
        this.cobroID = cobroID;
    }

    public List<String> getCodigosEntradas() {
        return codigosEntradas;
    }

    public void setCodigosEntradas(List<String> codigosEntradas) {
        this.codigosEntradas = codigosEntradas;
    }
    
    
}
