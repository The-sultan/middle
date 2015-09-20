package uy.edu.fing.middleware.obligatorio1.ws;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import uy.edu.fing.middleware.obligatorio1.ws.exceptions.CantidadInsuficienteEntradas;
import uy.edu.fing.middleware.obligatorio1.ws.exceptions.LoginIncorrecto;
import uy.edu.fing.middleware.obligatorio1.ws.exceptions.MonedaNoEncontrada;


@WebService(targetNamespace = VentaEntradasEndpoint.NAMESPACE_URI)
public class VentaEntradasEndpoint {
	
	public static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	private final List<String> log = new ArrayList<>();
    
    @Resource
    WebServiceContext webServiceContext;
    
    Date date;

    @WebMethod
    public  List<String> ventaEntradas(@WebParam(name = "cantEntradas") @XmlElement(required=true) short cantEntradas, 
            @WebParam(name = "monedaID") @XmlElement(required=true) String monedaID, 
            @WebParam(name = "monto") @XmlElement(required=true) BigDecimal monto, 
            @WebParam(name = "fecha") @XmlElement(required=true) GregorianCalendar fecha) 
            throws LoginIncorrecto,MonedaNoEncontrada, CantidadInsuficienteEntradas{
       
    	
    	date = new Date();
        String msg = "";
        String requestMsg = String.format("cantEntradas: %d, monedaID: %s, monto: %s, fecha: %tB",cantEntradas, monedaID, NumberFormat.getCurrencyInstance().format(monto), fecha);
        log.add(date + ": -->" + requestMsg);
        
        List<String> respuesta = new ArrayList<>();
        respuesta.add(String.valueOf(System.currentTimeMillis()));
        for (int i = 0 ; i<cantEntradas ; i ++ ) {
        	respuesta.add(String.valueOf(i));
        }
       
        log.add(date + ": -->" + respuesta.toString());
        
        return respuesta;
	}
    
    @WebMethod
    public @WebResult(name="log") List<String> ventaEntradaLog(){
        return log;
    }

}
