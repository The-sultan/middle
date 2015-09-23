package uy.edu.fing.inco.lins.endpoints.transformers;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import uy.edu.fing.inco.lins.domain.PagoMOM;
import uy.edu.fing.inco.lins.domain.PagoOffline;

/**
 * @author Mauricio Vignale
 * @author Farid
 */
@MessageEndpoint
public class PagoToPagoOfflineTransformer {

	@Transformer(inputChannel="pagoOffline", outputChannel="partnerOffline")
	public PagoOffline pagoFacturaConverter(PagoMOM pagoMOM) {
		PagoOffline result = new PagoOffline();
		result.setIdentificadorCliente(pagoMOM.getIdentificadorPago());
		result.setCodigoMoneda(pagoMOM.getCodigoMoneda());
		result.setMonto(pagoMOM.getMonto());
		result.setFechaCobro(pagoMOM.getFechaPago().toGregorianCalendar().getTime());
		result.setHoraCobro(pagoMOM.getFechaPago().toGregorianCalendar().getTime());
		return result;
	}

}
