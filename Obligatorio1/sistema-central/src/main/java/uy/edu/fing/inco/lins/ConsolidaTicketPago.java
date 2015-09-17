package uy.edu.fing.inco.lins;

import java.util.List;

import uy.edu.fing.inco.lins.RespuestaTicketPago;
import uy.edu.fing.inco.lins.TicketPago;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.integration.annotation.MessageEndpoint;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class ConsolidaTicketPago {

	@Aggregator(inputChannel = "ticketChannel", outputChannel = "responseChannel")
	public RespuestaTicketPago prepareDelivery(List<TicketPago> tickets) {
		return new RespuestaTicketPago(tickets);
	}

	@CorrelationStrategy
	public int correlateByOrderNumber(TicketPago ticket) {
		return ticket.getOrdenId();
	}

}
