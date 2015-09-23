package uy.edu.fing.inco.lins.endpoints.ServiceActivators;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.partnerfactura.PagoFacturaEndpoint;
import uy.edu.fing.inco.lins.generated.partnerfactura.PagoFacturaRequest;

/**
 * @author Farid
 */
@Component
public class FacturaServiceActivator extends AbstractServiceActivator<PagoFacturaEndpoint,PagoFacturaRequest>{

    @Override
    public ConfirmacionPago call(PagoFacturaRequest o) throws Exception {
        ConfirmacionPago confirmacionPago = new ConfirmacionPago();
        this.getPort().pagoFactura(o);
        confirmacionPago.setDescripcion("Pago confirmado");
        return confirmacionPago;
    }
}
