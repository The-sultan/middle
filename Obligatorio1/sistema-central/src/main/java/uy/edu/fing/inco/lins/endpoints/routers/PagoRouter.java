package uy.edu.fing.inco.lins.endpoints.routers;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import uy.edu.fing.inco.lins.domain.PagoMOM;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class PagoRouter {

	@Router(inputChannel="pagoIndividualEnriched")
	public String resolveOrderItemChannel(PagoMOM pagoItem) {
		switch(pagoItem.getNombreGestion()) {
 			case "Entradas":
			 	return "pagoEntradas";
 			case "Factura":
 				return "pagoFacturas";
            case "Offline":
 	 			return "pagoOffline";
            default : 
                throw new RuntimeException();
 		}
	}

}
