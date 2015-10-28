package uy.edu.fing.middleware.obligatorio2.interfaces;

import java.util.List;

import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.domain.DatoReserva;
import uy.edu.fing.middleware.obligatorio2.domain.DatoSalida;


@WebService
public interface StockLocal {
	
	
	DatoSalida reservaProductos(List<DatoReserva> productos) throws Exception;

	
	DatoSalida anularReserva(Long idReserva) throws Exception;
 

	List<String> stockLocalLog() throws Exception;

}
