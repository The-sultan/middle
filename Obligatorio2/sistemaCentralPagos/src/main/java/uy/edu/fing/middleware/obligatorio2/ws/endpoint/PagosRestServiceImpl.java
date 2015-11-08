package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import uy.edu.fing.middleware.obligatorio2.domain.Pago;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.PagosRestService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.PagosRestService",
			serviceName="PagosRestService")
public class PagosRestServiceImpl implements PagosRestService{

	@WebMethod
	public void pagoYa(@WebParam (name = "pagoRequest")@XmlElement(required=true) Pago pago) {
		System.out.println(); 
		
	}
	
	

}
