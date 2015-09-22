package uy.edu.fing.inco.lins.endpoints.splitters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import uy.edu.fing.inco.lins.domain.PagoMOM;

import uy.edu.fing.inco.lins.generated.Pago;
import uy.edu.fing.inco.lins.generated.TransaccionPago;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class OrdenPagoSplitter {

	@Splitter(inputChannel="ordenes", outputChannel="pagoIndividual")
	public List<PagoMOM> split(TransaccionPago orden) {
		List<PagoMOM> result = new ArrayList<>();
		for (Pago  pago : orden.getPagos()) {
			PagoMOM pagoMom = new PagoMOM();
			pagoMom.setCodigoMoneda(pago.getCodigoMoneda());
			pagoMom.setIdentificadorPago(pago.getIdentificadorPago());
			pagoMom.setMonto(pago.getMonto());
			pagoMom.setNombreGestion(pago.getNombreGestion());
			pagoMom.getDatoAdicional().addAll(pago.getDatoAdicional());
//			ACA ESTA LA CAUSA DE PORQUE PRECISAMOS UN PAGOMOM, la fecha debe ir individual por pago
			pagoMom.setFechaPago(orden.getFechaCobro());
			result.add(pagoMom);
		}
		return result;
	}

}
