package uy.edu.fing.inco.lins.endpoints;

import java.math.BigDecimal;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import uy.edu.fing.inco.lins.domain.PagoMOM;
import uy.edu.fing.inco.lins.domain.VentaEntradasMOM;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class VentaEntradaConverter {

	@Transformer(inputChannel="pagoEntradas", outputChannel="partnerEntradas")
	public VentaEntradasMOM ventaEntradasConverter(PagoMOM pagoMOM) {
		VentaEntradasMOM result = new VentaEntradasMOM();
		result.setIdentificadorPago(pagoMOM.getIdentificadorPago());
		result.setCantEntradas(Short.parseShort(pagoMOM.getDatoAdicional().get(0)));
		result.setFecha(pagoMOM.getFechaPago());
		if ("UYU".equals(pagoMOM.getCodigoMoneda())) {
			result.setMonedaID("854");
		} else if ("USD".equals(pagoMOM.getCodigoMoneda())) {
			result.setMonedaID("840");
		} else {
			// OTHERS
			result.setMonedaID("999");
		}
		result.setMonto(new BigDecimal(pagoMOM.getMonto()));
		return result;
	}

}
