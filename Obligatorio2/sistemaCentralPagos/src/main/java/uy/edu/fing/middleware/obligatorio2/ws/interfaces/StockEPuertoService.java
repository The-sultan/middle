package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import java.util.List;

import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.domain.ReservaEPuerto;

@WebService
//@Addressing(enabled=true,required=true)
public interface StockEPuertoService {
	
	public List<String> stock(ReservaEPuerto item);

}
