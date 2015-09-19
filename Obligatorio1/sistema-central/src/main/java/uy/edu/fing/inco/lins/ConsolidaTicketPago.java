package uy.edu.fing.inco.lins;

import java.util.List;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.integration.annotation.MessageEndpoint;

import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.ConfirmacionTransaccion;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class ConsolidaTicketPago {

	@Aggregator(inputChannel = "ticketChannel", outputChannel = "responseChannel")
	public ConfirmacionTransaccion prepareDelivery(List<ConfirmacionPago> tickets) {
		ConfirmacionTransaccion ct = new ConfirmacionTransaccion();
		ConfirmacionPago cp = new ConfirmacionPago();
		cp.setDescripcion("test");
		ct.getConfirmacion().add(cp);
		return ct;
	}

	@CorrelationStrategy
	public long correlateByOrderNumber(ConfirmacionPago ticket) {
		return ticket.getIdentificadorPago();
	}

}
