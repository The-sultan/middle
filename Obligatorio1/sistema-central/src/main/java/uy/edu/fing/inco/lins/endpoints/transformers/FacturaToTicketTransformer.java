package uy.edu.fing.inco.lins.endpoints.transformers;


import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;

/**
 * @author Farid
 */
@MessageEndpoint
public class FacturaToTicketTransformer {

	@Transformer(inputChannel="pagoFacturaTransformerChannel", outputChannel="ticketChannel")
	public ConfirmacionPago pagoFacturaConverter(Integer pagoId) {
		ConfirmacionPago result = new ConfirmacionPago();
        result.setResultado("OK");
        result.setIdentificadorPago(pagoId);
        result.setDescripcion("Pago confirmado");
        return result;
	}

}
