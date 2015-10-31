package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.domain.Orden;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService",
			serviceName="CompraService")
public class CompraServiceImpl implements CompraService{

	@Override
	public void compra(Orden orden) {
		System.out.println(orden); 
		
	}
	
	

}
