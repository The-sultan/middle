package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.domain.Pago;

@WebService
//@Addressing(enabled=true,required=true)
public interface PagosRestService {
	
	public void pagoYa(Pago item);

}
