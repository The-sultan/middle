package uy.edu.fing.inco.lins;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import uy.edu.fing.inco.lins.generated.Pago;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class PagoRouter {

	@Router(inputChannel="pagoIndividual")
	public String resolveOrderItemChannel(Pago pagoItem) {
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
