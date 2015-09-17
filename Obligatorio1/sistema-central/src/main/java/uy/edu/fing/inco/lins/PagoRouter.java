package uy.edu.fing.inco.lins;

import uy.edu.fing.inco.lins.OrdenPagoItem;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import uy.edu.fing.inco.lins.TipoPago;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class PagoRouter {

	@Router(inputChannel="pagoIndividual")
	public String resolveOrderItemChannel(OrdenPagoItem ordenPagoItem) {
		switch(ordenPagoItem.getTipoPago()) {
 			case ENTRADAS:
			 	return "pagoEntradas";
 			case FACTURA:
     		return "pagoFacturas";
 	 		default:
     		return "pagoOffline";
 		}
	}

}
