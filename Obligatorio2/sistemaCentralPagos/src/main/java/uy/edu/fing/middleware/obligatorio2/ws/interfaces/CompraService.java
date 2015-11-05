package uy.edu.fing.middleware.obligatorio2.ws.interfaces;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import uy.edu.fing.middleware.obligatorio2.domain.Orden;

@WebService
//@Addressing(enabled=true,required=true)
public interface CompraService {
	
	public void compra(Orden orden);

}
