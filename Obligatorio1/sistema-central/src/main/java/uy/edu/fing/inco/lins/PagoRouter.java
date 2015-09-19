package uy.edu.fing.inco.lins;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class PagoRouter {

	@Router(inputChannel="pagoIndividual")
	public String resolveOrderItemChannel(PagoMOM pagoItem) {
		switch(pagoItem.getNombreGestion()) {
 			case "ENTRADAS":
			 	return "pagoEntradas";
 			case "FACTURAS":
 				return "pagoFacturas";
 	 		default:
 	 			return "pagoOffline";
 		}
	}

}
