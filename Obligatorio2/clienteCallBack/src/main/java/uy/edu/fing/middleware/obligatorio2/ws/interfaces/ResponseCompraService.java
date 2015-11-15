package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;

@WebService()
public interface ResponseCompraService {

	String NS = "http://interfaces.ws.obligatorio2.middleware.fing.edu.uy/";
	 
	@Oneway
	@RequestWrapper(localName="compraResponse", targetNamespace=NS)
	public void callBack(@WebParam(name="return") String callbackMessage);
}
