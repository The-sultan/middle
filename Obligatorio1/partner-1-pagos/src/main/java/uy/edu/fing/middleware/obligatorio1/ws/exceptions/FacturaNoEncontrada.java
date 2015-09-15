package uy.edu.fing.middleware.obligatorio1.ws.exceptions;

import javax.xml.ws.WebFault;
import uy.edu.fing.middleware.obligatorio1.ws.PagoFacturaEndpoint;

/**
 * @author Farid
 */
@WebFault(name = "FacturaIncorrecta",targetNamespace = PagoFacturaEndpoint.NAMESPACE_URI)
public class FacturaNoEncontrada extends Exception{

    public FacturaNoEncontrada(String message) {
        super(message);
    }
    
    
}
