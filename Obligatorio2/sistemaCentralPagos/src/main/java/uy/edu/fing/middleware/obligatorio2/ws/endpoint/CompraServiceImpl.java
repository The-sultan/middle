package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import uy.edu.fing.middleware.obligatorio2.domain.Orden;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService",
			serviceName="CompraService")
public class CompraServiceImpl implements CompraService{

	@WebMethod
	public void compra(@WebParam (name = "ordenRequest")@XmlElement(required=true) Orden orden) {
		System.out.println(orden); 
		
	}
	
	

}
