package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import javax.jws.WebService;

@WebService
//@Addressing(enabled=true,required=true)
public interface AnularStockAmazoniaService {
	
	public void anular(Long idReserva);

}
