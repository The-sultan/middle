package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import uy.edu.fing.middleware.obligatorio2.ws.interfaces.CancelaEPuertoService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService",
			serviceName="StockService")
public class CancelaEPuertoServiceImpl implements CancelaEPuertoService{

	@WebMethod
	public void cancela(Long idReserva) {
		// TODO Auto-generated method stub
		
	}
	
	

}
