package uy.edu.fing.middleware.obligatorio2.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import uy.edu.fing.middleware.obligatorio2.domain.DatoReserva;
import uy.edu.fing.middleware.obligatorio2.domain.DatoSalida;
import uy.edu.fing.middleware.obligatorio2.interfaces.StockLocal;


@WebService(endpointInterface = "uy.edu.fing.middleware.obligatorio2.interfaces.StockLocal",
serviceName = "StockLocal")
public class StockLocalEndpoint implements StockLocal{
	
	private final List<String> log = new ArrayList<String>();
	
	@WebMethod
	public @WebResult(name="reservaProductosResponse") DatoSalida reservaProductos(@WebParam (name = "reservaProductosRequest" ) @XmlElement(required=true) List<DatoReserva> productos) throws Exception {
		System.out.println("Reservar Productos");
		return null;
	}
	
	@WebMethod
	public @WebResult(name="anularReservaResponse") DatoSalida anularReserva(@WebParam (name = "anularReservaRequest" ) @XmlElement(required=true) Long idReserva) throws Exception{
		System.out.println("Anular Reserva");
		return null;
	}
 
	@WebMethod
	public @WebResult(name="stockLocalLogResponse") List<String> stockLocalLog(){
		System.out.println("Login Reserva");
		return this.log;
	}
}
