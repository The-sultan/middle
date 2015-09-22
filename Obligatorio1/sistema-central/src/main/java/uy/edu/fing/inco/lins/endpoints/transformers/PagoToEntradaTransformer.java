package uy.edu.fing.inco.lins.endpoints.transformers;

import java.math.BigDecimal;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import uy.edu.fing.inco.lins.domain.PagoMOM;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasRequest;

/**
 * @author Mauricio Vignale
 */
@MessageEndpoint
public class PagoToEntradaTransformer {

	@Transformer(inputChannel="pagoEntradas", outputChannel="partnerEntradas")
	public VentaEntradasRequest ventaEntradasConverter(PagoMOM pagoMOM) {
		VentaEntradasRequest result = new VentaEntradasRequest();
		result.setCantEntradas(Short.parseShort(pagoMOM.getDatoAdicional().get(0)));
		result.setFecha(pagoMOM.getFechaPago());
		if (null != pagoMOM.getCodigoMoneda()) switch (pagoMOM.getCodigoMoneda()) {
            case "UYU":
                result.setMonedaID("854");
                break;
            case "USD":
                result.setMonedaID("840");
                break;
            default:
                throw new RuntimeException();
        }
		result.setMonto(new BigDecimal(pagoMOM.getMonto()));
		return result;
	}

}
