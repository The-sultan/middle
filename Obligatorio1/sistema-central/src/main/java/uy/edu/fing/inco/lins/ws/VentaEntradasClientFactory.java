package uy.edu.fing.inco.lins.ws;

import java.util.Collections;
import org.apache.commons.codec.binary.Base64;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasEndpoint;

/**
 * @author Farid
 */
@Component("ventaServiceFactory")
public class VentaEntradasClientFactory {

    
    @Autowired @Qualifier("ventaService")
    private VentaEntradasEndpoint ventaEntradasEndpoint;
    
    public VentaEntradasEndpoint endpointFactory() {
        
        
        BindingProvider provider = ((BindingProvider)ventaEntradasEndpoint);
        String credenciales = "basic " + Base64.encodeBase64String("ventas:ventas".getBytes());
        provider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, Collections.singletonMap("Authorization",Collections.singletonList(credenciales)));
        return ventaEntradasEndpoint;
    }
}
