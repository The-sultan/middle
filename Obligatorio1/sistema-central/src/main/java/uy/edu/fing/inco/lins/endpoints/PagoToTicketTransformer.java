package uy.edu.fing.inco.lins.endpoints;


import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;

/**
 * @author Farid
 */
@MessageEndpoint
public class PagoToTicketTransformer {

	@Transformer(inputChannel="pagoResponseTransformerChannel", outputChannel="ticketChannel")
	public ConfirmacionPago pagoFacturaConverter(Integer pagoId) {
		ConfirmacionPago result = new ConfirmacionPago();
        result.setResultado("OK");
        result.setIdentificadorPago(pagoId);
        result.setDescripcion("Pago confirmado");
        return result;
	}

}
