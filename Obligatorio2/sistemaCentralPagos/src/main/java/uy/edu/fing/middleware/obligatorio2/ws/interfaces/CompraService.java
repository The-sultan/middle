package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import javax.jws.WebService;

import uy.edu.fing.middleware.obligatorio2.domain.Orden;

@WebService
public interface CompraService {
	
	public void compra(Orden orden);

}
