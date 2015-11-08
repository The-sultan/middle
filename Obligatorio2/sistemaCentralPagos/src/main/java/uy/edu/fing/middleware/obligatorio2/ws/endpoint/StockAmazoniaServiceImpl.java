package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import uy.edu.fing.middleware.obligatorio2.domain.Item;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.StockAmazoniaService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService",
			serviceName="StockService")
public class StockAmazoniaServiceImpl implements StockAmazoniaService{

	@WebMethod
	public void stock(@WebParam (name = "stockRequest")@XmlElement(required=true) Item item) {
		System.out.println(item); 
		
	}
	
	

}
