package uy.edu.fing.inco.lins.endpoints.transformers;


import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasResult;

/**
 * @author Farid
 */
@MessageEndpoint
public class EntradaToTicketTransformer {

	@Transformer(inputChannel="pagoVentaTransformerChannel", outputChannel="ticketChannel")
	public ConfirmacionPago pagoVentaConverter(VentaEntradasResult resultado) {
		ConfirmacionPago result = new ConfirmacionPago();
        result.setResultado("OK");
        result.setIdentificadorPago(resultado.getCobroID());
        result.setDescripcion(resultado.getCodigosEntradas().toString());
        return result;
	}

}
