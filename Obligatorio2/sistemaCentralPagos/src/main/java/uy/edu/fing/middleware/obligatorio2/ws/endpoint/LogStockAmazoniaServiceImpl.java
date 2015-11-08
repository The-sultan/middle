package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.ws.interfaces.LogStockAmazoniaService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService",
			serviceName="StockService")
public class LogStockAmazoniaServiceImpl implements LogStockAmazoniaService{

	@WebMethod
	public void log() {
		System.out.println(); 
		
	}
	
	

}
