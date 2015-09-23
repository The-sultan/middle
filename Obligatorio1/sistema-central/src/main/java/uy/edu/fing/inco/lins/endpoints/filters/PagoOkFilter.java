package uy.edu.fing.inco.lins.endpoints.filters;

import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Component;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;

/**
 * @author Farid
 */
@Component
public class PagoOkFilter {
    
    @Filter(inputChannel = "ticketChannel", outputChannel="lealtadChannel")
    public boolean pagoEstaOk(ConfirmacionPago pago){
        return pago.getResultado().equals("OK");
    }
}
