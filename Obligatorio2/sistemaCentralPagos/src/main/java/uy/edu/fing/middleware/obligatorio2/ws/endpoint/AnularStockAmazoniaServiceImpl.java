package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import uy.edu.fing.middleware.obligatorio2.domain.Item;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.AnularStockAmazoniaService;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.StockAmazoniaService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.AnularStockAmazoniaService",
			serviceName="AnularAmazoniaService")
public class AnularStockAmazoniaServiceImpl implements AnularStockAmazoniaService{

	@WebMethod
	public void anular(Long idReserva) {
		// TODO Auto-generated method stub
		
	}
	
	

}
