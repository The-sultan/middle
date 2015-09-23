package uy.edu.fing.inco.lins.endpoints.Aggregators;

import java.util.List;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.MessageEndpoint;

import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.ConfirmacionTransaccion;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class TicketAggregator {

	@Aggregator(inputChannel = "ticketChannel", outputChannel = "responseChannel")
	public ConfirmacionTransaccion prepareDelivery(List<ConfirmacionPago> tickets) {
		ConfirmacionTransaccion ct = new ConfirmacionTransaccion();
		ct.getConfirmacion().addAll(tickets);
		return ct;
	}

}
