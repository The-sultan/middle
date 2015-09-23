package uy.edu.fing.inco.lins.endpoints.ServiceActivators;

import org.springframework.stereotype.Component;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasEndpoint;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasRequest;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasResult;

/**
 *
 * @author Farid
 */
@Component
public class EntradaServiceActivator extends AbstractServiceActivator<VentaEntradasEndpoint, VentaEntradasRequest> {

    @Override
    public ConfirmacionPago call(VentaEntradasRequest o) throws Exception {
        ConfirmacionPago confirmacionPago = new ConfirmacionPago();
        VentaEntradasResult resultado = this.getPort().ventaEntradas(o);
        confirmacionPago.setDescripcion(resultado.getCodigosEntradas().toString());
        return confirmacionPago;
    }

}
