package uy.edu.fing.inco.lins;

import org.springframework.integration.annotation.Gateway;

import uy.edu.fing.inco.lins.generated.ConfirmacionTransaccion;
import uy.edu.fing.inco.lins.generated.TransaccionPago;

/**
 * @author Mauricio Vignale
 */
public interface PagoCliente {

	@Gateway(requestChannel="ordenes", replyChannel="responseChannel")
	ConfirmacionTransaccion despacharOrden(TransaccionPago orden);

}
