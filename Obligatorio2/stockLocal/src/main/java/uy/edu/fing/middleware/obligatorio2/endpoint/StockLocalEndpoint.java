package uy.edu.fing.middleware.obligatorio2.endpoint;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.apache.log4j.Logger;

import uy.edu.fing.middleware.obligatorio2.domain.DatoReserva;
import uy.edu.fing.middleware.obligatorio2.domain.DatoSalida;
import uy.edu.fing.middleware.obligatorio2.interfaces.StockLocal;


@WebService(endpointInterface = "uy.edu.fing.middleware.obligatorio2.interfaces.StockLocal", serviceName = "StockLocal")
@org.apache.cxf.interceptor.InInterceptors (interceptors = {"org.apache.cxf.interceptor.LoggingInInterceptor" })
@org.apache.cxf.interceptor.OutInterceptors (interceptors = {"org.apache.cxf.interceptor.LoggingOutInterceptor" })
public class StockLocalEndpoint implements StockLocal{
	
	private static final Logger logger = Logger.getLogger(StockLocalEndpoint.class);
	
	private final List<String> log = new ArrayList<String>();
	
	private final Set<Long> reservas =  new HashSet<Long>();
	
	@WebMethod
	public @WebResult(name="reservaProductosResponse") DatoSalida reservaProductos(@WebParam (name = "reservaProductosRequest" ) @XmlElement(required=true) List<DatoReserva> productos) throws Exception {
		logger.info("Reservar Productos " + productos);
		DatoSalida ret  = new DatoSalida();
		boolean save = true;
        for (DatoReserva datoReserva : productos) {
			if (datoReserva.getIdProducto().equals(5L)){
				save = false;
			}
		}
        if (save) {
        	Long idReserva = System.currentTimeMillis();        	
        	reservas.add(idReserva);
        	ret.setCodigo("OK");
        	ret.setIdReserva(Long.valueOf(idReserva));
        	ret.setDescripcion("TEST RESERVA OK");
        }else{
        	ret.setCodigo("Error");
        	ret.setDescripcion("TEST RESERVA ERROR");
        }
        
		logger.info("Reservar Productos Response " + ret);
		return ret;
	}
	
	@WebMethod
	public @WebResult(name="anularReservaResponse") DatoSalida anularReserva(@WebParam (name = "anularReservaRequest" ) @XmlElement(required=true) Long idReserva) throws Exception{
		
		logger.info("Anular Reserva  " + idReserva);
		DatoSalida ret  = new DatoSalida();
		if (reservas.contains(idReserva)){
			logger.info("Vamos a anular la reserva : " + idReserva);
			reservas.remove(idReserva);
			ret.setDescripcion("Se anulo la reserva " + idReserva);
			ret.setCodigo("TEST ANULACION OK");
		}else{
			logger.info("No se encuentra la reserva : " + idReserva);
			ret.setDescripcion("No se pudo anular la reserva " + idReserva);
			ret.setCodigo("TEST ANULACION ERROR");
		}
		logger.info("Anular Reserva Response " + ret);
		return ret;
	}
 
	@WebMethod
	public @WebResult(name="stockLocalLogResponse") List<String> stockLocalLog(){
		System.out.println("Login Reserva");
		String now = Calendar.getInstance().toString();
		log.add(now);
		return this.log;
	}
}
