package uy.edu.fing.inco.lins.endpoints.ServiceActivators;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;

/**
 *
 * @author Farid
 */
@Component
public class EchoServiceActivator {
    @ServiceActivator(inputChannel = "jmsChannel")
    public void printOkPagos(Message<ConfirmacionPago> confirmacion) {
        System.out.println(String.format("Headers: %s", confirmacion.getHeaders().toString()));
    }
}
