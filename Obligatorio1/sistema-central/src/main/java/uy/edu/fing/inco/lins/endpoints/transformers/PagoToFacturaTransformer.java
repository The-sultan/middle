package uy.edu.fing.inco.lins.endpoints.transformers;

import java.math.BigDecimal;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import uy.edu.fing.inco.lins.domain.PagoMOM;
import uy.edu.fing.inco.lins.generated.partnerfactura.PagoFacturaRequest;

/**
 * @author Mauricio Vignale
 * @author Farid
 */
@MessageEndpoint
public class PagoToFacturaTransformer {

	@Transformer(inputChannel="pagoFacturas", outputChannel="partnerFacturas")
	public PagoFacturaRequest pagoFacturaConverter(PagoMOM pagoMOM) {
		PagoFacturaRequest result = new PagoFacturaRequest();
		result.setFacturaID(pagoMOM.getIdentificadorPago());
		result.setFecha(pagoMOM.getFechaPago());
		if ("UYU".equals(pagoMOM.getCodigoMoneda())) {
			result.setMonedaID((short) 1);
		} else if ("USD".equals(pagoMOM.getCodigoMoneda())) {
			result.setMonedaID((short) 2);
		} else {
			throw new RuntimeException();
		}
		result.setMonto(new BigDecimal(pagoMOM.getMonto()));
		return result;
	}

}
