package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.domain.Item;
import uy.edu.fing.middleware.obligatorio2.domain.AmazoniaResponse;

@WebService
//@Addressing(enabled=true,required=true)
public interface StockAmazoniaService {
	
	public void stock(Item item);

}
