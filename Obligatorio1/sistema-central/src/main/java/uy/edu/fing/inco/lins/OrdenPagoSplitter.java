package uy.edu.fing.inco.lins;

import java.util.List;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import uy.edu.fing.inco.lins.generated.Pago;
import uy.edu.fing.inco.lins.generated.TransaccionPago;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class OrdenPagoSplitter {

	@Splitter(inputChannel="ordenes", outputChannel="pagoIndividual")
	public List<Pago> split(TransaccionPago orden) {
		return orden.getPagos();
	}

}
