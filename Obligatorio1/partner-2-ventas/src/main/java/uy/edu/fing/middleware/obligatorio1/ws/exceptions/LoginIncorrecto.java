package uy.edu.fing.middleware.obligatorio1.ws.exceptions;

import javax.xml.ws.WebFault;
import uy.edu.fing.middleware.obligatorio1.ws.VentaEntradasEndpoint;


@WebFault(name = "LoginIncorrecto",targetNamespace = VentaEntradasEndpoint.NAMESPACE_URI)
public class LoginIncorrecto extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8518024734386250213L;

	public LoginIncorrecto(String message) {
        super(message);
    }
    
    
}
