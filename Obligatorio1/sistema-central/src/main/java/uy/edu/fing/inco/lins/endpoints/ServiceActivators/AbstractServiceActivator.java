package uy.edu.fing.inco.lins.endpoints.ServiceActivators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import uy.edu.fing.inco.lins.generated.ConfirmacionPago;

/**
 *
 * @author Farid
 * @param <T> Web service port type
 * @param <S> Web service input type
 */
public abstract class AbstractServiceActivator<T, S> {

    @Autowired
    private T port;
    
    public Message<ConfirmacionPago> callService(Message<S> message) {
        MessageHeaders requestMessageHeaders = message.getHeaders();
        ConfirmacionPago confirmacionPago;
        try{
            confirmacionPago = this.call(message.getPayload());
            confirmacionPago.setResultado("OK");
        }
        catch (Exception ex) {
            confirmacionPago = new ConfirmacionPago();
            confirmacionPago.setResultado("Error");
            confirmacionPago.setDescripcion(ex.getMessage());
        }
        confirmacionPago.setIdentificadorPago(message.getHeaders().get("idPago", Long.class));
        GenericMessage<ConfirmacionPago> responseMessage = new GenericMessage<>(confirmacionPago, requestMessageHeaders);
        return responseMessage;
    }

    public T getPort() {
        return port;
    }

    public void setPort(T port) {
        this.port = port;
    }

    
    public abstract ConfirmacionPago call(S o) throws Exception;
}
