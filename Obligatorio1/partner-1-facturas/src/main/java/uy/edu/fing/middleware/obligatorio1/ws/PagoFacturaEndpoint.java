package uy.edu.fing.middleware.obligatorio1.ws;


import java.math.BigDecimal;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

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

    @WebMethod
    public  Integer pagoFactura(@WebParam(name = "facturaID") @XmlElement(required=true) Long facturaID, 
            @WebParam(name = "monedaID") @XmlElement(required=true) short monedaID, 
            @WebParam(name = "monto") @XmlElement(required=true) BigDecimal monto, 
            @WebParam(name = "fecha") @XmlElement(required=true) GregorianCalendar fecha) 
            throws FacturaNoEncontrada, MonedaNoEncontrada {
        date = new Date();
        String msg = "";
        String requestMsg = String.format("facturaID: %d, monedaID: %d, monto: %s, fecha: %tB",facturaID, monedaID, NumberFormat.getCurrencyInstance().format(monto), fecha);
        log.add(date + ": -->" + requestMsg);
        if(monedaID!= 1 && monedaID!= 2){
            msg = "Moneda no encontrada";
            log.add(date + ": -->" + msg);
            throw new MonedaNoEncontrada(msg);
        }
        if(facturaID!= 666 ){
            msg = "Factura no encontrada";
            log.add(date + ": -->" + msg);
            throw new FacturaNoEncontrada(msg);
        }
        Integer response = 1942;
        log.add(date + ": -->" + response);
        return response;
	}
    
    @WebMethod
    public @WebResult(name="log") List<String> pagoFacturaLog(){
        return log;
    }

}
