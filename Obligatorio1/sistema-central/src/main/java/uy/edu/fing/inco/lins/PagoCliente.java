package uy.edu.fing.inco.lins;

import org.springframework.integration.annotation.Gateway;

/**
 * @author Mauricio Vignale
 */
public interface PagoCliente {

	@Gateway(requestChannel="ordenes")
	void despacharOrden(OrdenPago orden);

}
