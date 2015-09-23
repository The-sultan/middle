package uy.edu.fing.inco.lins.endpoints.aggregators;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;

import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.ConfirmacionTransaccion;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class TicketAggregator {

	@Aggregator(inputChannel = "ticketChannel", outputChannel = "responseChannel")
	public ConfirmacionTransaccion prepareDelivery(List<Message<ConfirmacionPago>> tickets) {
        Collections.sort(tickets, new Comparator<Message<ConfirmacionPago>>() {

            @Override
            public int compare(Message<ConfirmacionPago> o1, Message<ConfirmacionPago> o2) {
                return Integer.compare(o1.getHeaders().get("sequenceNumber", Integer.class),o2.getHeaders().get("sequenceNumber", Integer.class));
            }
        });
		ConfirmacionTransaccion ct = new ConfirmacionTransaccion();
        for(Message<ConfirmacionPago> msg : tickets){
            ct.getConfirmacion().add(msg.getPayload());    
        }
		return ct;
	}

}
