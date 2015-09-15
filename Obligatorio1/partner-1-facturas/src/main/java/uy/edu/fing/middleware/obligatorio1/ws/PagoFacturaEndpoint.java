package uy.edu.fing.middleware.obligatorio1.ws;


import uy.edu.fing.middleware.obligatorio1.ws.domain.PagoFacturaRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import uy.edu.fing.middleware.obligatorio1.ws.domain.PagoFacturaLogReply;
import uy.edu.fing.middleware.obligatorio1.ws.domain.PagoFacturaReply;

import uy.edu.fing.middleware.obligatorio1.ws.exceptions.FacturaNoEncontrada;
import uy.edu.fing.middleware.obligatorio1.ws.exceptions.MonedaNoEncontrada;

/**
 *
 * @author Farid
 */
@WebService(targetNamespace = PagoFacturaEndpoint.NAMESPACE_URI)
public class PagoFacturaEndpoint {
	public static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
    private final List<String> log = new ArrayList<>();
    
    Date date;
    
	//@PayloadRoot(namespace = NAMESPACE_URI, localPart = "pagoFacturaRequest")
	//@ResponsePayload
    //
    @WebMethod
    public PagoFacturaReply pagoFactura(PagoFacturaRequest request) throws FacturaNoEncontrada, MonedaNoEncontrada {
		PagoFacturaReply response = new PagoFacturaReply();
        date = new Date();
        String msg = "";
        log.add(date + ": -->" + request.toString());
        if(request.getMonedaID() != 1 && request.getMonedaID() != 2){
            msg = "Moneda no encontrada";
            log.add(date + ": -->" + msg);
            throw new MonedaNoEncontrada(msg);
        }
        if(request.getFacturaID() != 666 ){
            msg = "Factura no encontrada";
            log.add(date + ": -->" + msg);
            throw new FacturaNoEncontrada(msg);
        }
        response.setCobroID(1942L);
        log.add(date + ": -->" + response.toString());
        return response;
	}
    
    @WebMethod
    public PagoFacturaLogReply pagoFacturaLog(){
        PagoFacturaLogReply response = new PagoFacturaLogReply();
        response.setLogList(log);
        return response;
    }

}
