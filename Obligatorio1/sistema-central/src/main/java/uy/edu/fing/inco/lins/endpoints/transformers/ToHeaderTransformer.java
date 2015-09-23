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
        headers.put("moneda",request.getPayload().getCodigoMoneda());
        headers.put("monto",request.getPayload().getMonto());
        headers.put("fecha",request.getPayload().getFechaPago());
        headers.put("idPago",request.getPayload().getIdentificadorPago());
        GenericMessage<PagoMOM> response = new GenericMessage<>(request.getPayload(),headers);
        return response;
    }
}
