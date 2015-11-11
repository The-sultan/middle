package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.domain.Item;
import uy.edu.fing.middleware.obligatorio2.domain.AmazoniaResponse;

@WebService
public interface StockAmazoniaService {
	
	public AmazoniaResponse stock(Item item);

}
