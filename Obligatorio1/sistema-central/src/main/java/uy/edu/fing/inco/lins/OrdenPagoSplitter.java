package uy.edu.fing.inco.lins;

import java.util.List;

import uy.edu.fing.inco.lins.OrdenPago;
import uy.edu.fing.inco.lins.OrdenPagoItem;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class OrdenPagoSplitter {

	@Splitter(inputChannel="ordenes", outputChannel="pagoIndividual")
	public List<OrdenPagoItem> split(OrdenPago orden) {
		return orden.getItems();
	}

}
