package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.domain.AnularAmazoniaResponse;

@WebService
//@Addressing(enabled=true,required=true)
public interface AnularStockAmazoniaService {
	
	public AnularAmazoniaResponse anular(Long idReserva);

}
