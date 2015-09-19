package uy.edu.fing.inco.lins;

import java.math.BigDecimal;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class PagoFacturaConverter {

	@Transformer(inputChannel="pagoFacturas", outputChannel="partnerFacturas")
	public PagoFacturaMOM pagoFacturaConverter(PagoMOM pagoMOM) {
		PagoFacturaMOM result = new PagoFacturaMOM();
		result.setFacturaID(pagoMOM.getIdentificadorPago());
		result.setFecha(pagoMOM.getFechaPago());
		if ("UYU".equals(pagoMOM.getCodigoMoneda())) {
			result.setMonedaID((short) 1);
		} else if ("USD".equals(pagoMOM.getCodigoMoneda())) {
			result.setMonedaID((short) 2);
		} else {
			// OTROS
			result.setMonedaID((short) 3);
		}
		result.setMonto(new BigDecimal(pagoMOM.getMonto()));
		return result;
	}

}
