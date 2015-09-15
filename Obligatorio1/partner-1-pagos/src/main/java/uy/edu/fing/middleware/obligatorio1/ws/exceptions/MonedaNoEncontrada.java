package uy.edu.fing.middleware.obligatorio1.ws.exceptions;

import javax.xml.ws.WebFault;
import uy.edu.fing.middleware.obligatorio1.ws.PagoFacturaEndpoint;

/**
 * @author Farid
 */
@WebFault(name = "MonedaIncorrecta",targetNamespace = PagoFacturaEndpoint.NAMESPACE_URI)
public class MonedaNoEncontrada extends Exception{

    public MonedaNoEncontrada(String message) {
        super(message);
    }
    
}
