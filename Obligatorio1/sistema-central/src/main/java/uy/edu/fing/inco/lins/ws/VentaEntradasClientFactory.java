package uy.edu.fing.inco.lins.ws;

import java.util.Collections;
import org.apache.commons.codec.binary.Base64;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import org.springframework.stereotype.Component;

import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasEndpoint;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasEndpointService;

/**
 * @author Farid
 */
@Component("ventaServiceFactory")
public class VentaEntradasClientFactory {
    
    public VentaEntradasEndpoint endpointFactory() {
        
        VentaEntradasEndpointService ventaEntradasEndpointService = new VentaEntradasEndpointService();        
        VentaEntradasEndpoint ventaEntradasEndpoint = ventaEntradasEndpointService.getVentaEntradasEndpointPort();
        BindingProvider provider = ((BindingProvider)ventaEntradasEndpoint);
        String credenciales = "basic " + Base64.encodeBase64String("ventas:ventas".getBytes());
        provider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, Collections.singletonMap("Authorization",Collections.singletonList(credenciales)));
        return ventaEntradasEndpoint;
    }
}
