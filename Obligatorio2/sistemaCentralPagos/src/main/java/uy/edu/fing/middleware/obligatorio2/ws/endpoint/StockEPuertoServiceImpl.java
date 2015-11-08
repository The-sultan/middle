package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import uy.edu.fing.middleware.obligatorio2.domain.ReservaEPuerto;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.StockEPuertoService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService",
			serviceName="StockService")
public class StockEPuertoServiceImpl implements StockEPuertoService{

	@WebMethod
	public void stock(@WebParam (name = "stockRequest")@XmlElement(required=true) ReservaEPuerto item) {
		System.out.println(item); 
		
	}
	
	

}
