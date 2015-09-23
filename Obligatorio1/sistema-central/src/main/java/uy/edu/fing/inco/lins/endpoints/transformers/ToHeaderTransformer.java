package uy.edu.fing.inco.lins.endpoints.transformers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import uy.edu.fing.inco.lins.domain.PagoMOM;

/**
 * @author Farid
 */
@MessageEndpoint
public class ToHeaderTransformer {
    @Transformer(inputChannel = "pagoIndividual", outputChannel = "pagoIndividualEnriched")
    public Message<PagoMOM> toHeader(Message<PagoMOM> request){
        Map<String,Object> headers = new HashMap<>(request.getHeaders());
        PagoMOM pago = request.getPayload();
        headers.put("cliente", pago.getIdCliente());
        headers.put("moneda", pago.getCodigoMoneda());
        headers.put("monto", pago.getMonto());
        headers.put("fecha", pago.getFechaPago());
        headers.put("idPago", pago.getIdentificadorPago());
        GenericMessage<PagoMOM> response = new GenericMessage<>(pago, headers);
        return response;
    }
}
