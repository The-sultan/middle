package uy.edu.fing.inco.lins.endpoints.transformers;

import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import uy.edu.fing.inco.lins.domain.DatosLealtad;

/**
 * @author Farid
 */
@MessageEndpoint
public class HeadersToPayloadTransformer {
	
    @Transformer(inputChannel = "lealtadChannel", outputChannel = "lealtadSerializerChannel")
    public Message<DatosLealtad> toDatosLealtad(Message<?> request) {
    	
        Map<String, Object> headers = request.getHeaders();
        DatosLealtad datos = new DatosLealtad();
        datos.setIdCliente((Long) headers.get("cliente"));
        datos.setCodigoMoneda((String) headers.get("moneda"));
        datos.setMonto((Double) headers.get("monto"));
        datos.setFechaHoraCobro(((XMLGregorianCalendar) headers.get("fecha")).toGregorianCalendar().getTime());
        
        GenericMessage<DatosLealtad> response = new GenericMessage<>(datos);
        return response;
    }
}
