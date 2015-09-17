package uy.edu.fing.middleware.obligatorio1.ws.exceptions;

import javax.xml.ws.WebFault;

import uy.edu.fing.middleware.obligatorio1.ws.VentaEntradasEndpoint;


@WebFault(name = "MonedaIncorrecta",targetNamespace = VentaEntradasEndpoint.NAMESPACE_URI)
public class MonedaNoEncontrada extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1938669880804222348L;

	public MonedaNoEncontrada(String message) {
        super(message);
    }
    
}
