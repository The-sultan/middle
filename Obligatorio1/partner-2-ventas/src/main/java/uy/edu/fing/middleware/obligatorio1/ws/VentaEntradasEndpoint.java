package uy.edu.fing.middleware.obligatorio1.ws;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebServiceContext;
import uy.edu.fing.middleware.obligatorio1.ws.domain.VentaEntradasRequest;
import uy.edu.fing.middleware.obligatorio1.ws.domain.VentaEntradasResult;

import uy.edu.fing.middleware.obligatorio1.ws.exceptions.CantidadInsuficienteEntradas;
import uy.edu.fing.middleware.obligatorio1.ws.exceptions.MonedaNoEncontrada;


@WebService(targetNamespace = VentaEntradasEndpoint.NAMESPACE_URI)
public class VentaEntradasEndpoint {
	
	public static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	private final List<String> log = new ArrayList<>();
    
    @Resource
    WebServiceContext webServiceContext;
    
    Date date;

    @WebMethod
    public  VentaEntradasResult ventaEntradas(@XmlElement(required=true) VentaEntradasRequest ventaEntradas) 
            throws MonedaNoEncontrada, CantidadInsuficienteEntradas{
       
    	
    	date = new Date();
        String requestMsg = String.format("cantEntradas: %d, monedaID: %s, monto: %s, fecha: %s",ventaEntradas.getCantEntradas(),
                ventaEntradas.getMonedaID(), NumberFormat.getCurrencyInstance().format(ventaEntradas.getMonto()), ventaEntradas.getFecha() == null ? "" : ventaEntradas.getFecha().toString());
        log.add(date + ": -->" + requestMsg);
        String msg = "";
        if(ventaEntradas.getMonedaID().equals("854") && ventaEntradas.getMonedaID().equals("840")){
            msg = "Moneda no encontrada";
            log.add(date + ": -->" + msg);
            throw new MonedaNoEncontrada(msg);
        }
        
        //TODO ver que hacemos con el control de la cantidad de entradas 
        if (ventaEntradas.getCantEntradas() > 10){
        	msg = "Cantidad no disponible. Maximo disponible : " + 10;
            log.add(date + ": -->" + msg);
            throw new CantidadInsuficienteEntradas(msg);
        }
        
        
        VentaEntradasResult respuesta = new VentaEntradasResult();
        List<String> codigosEntradas = new ArrayList<>();
        for (int i = 0 ; i<ventaEntradas.getCantEntradas() ; i ++ ) {
        	codigosEntradas.add(String.valueOf(System.currentTimeMillis()));
        }
        respuesta.setCobroID((Double.valueOf(Math.random()*100).longValue()));
        respuesta.setCodigosEntradas(codigosEntradas);
        log.add(String.format("%tB: --> cobroid %d, Entradas: %s",date, respuesta.getCobroID(), respuesta.getCodigosEntradas().toString()));
        return respuesta;
	}
    
    @WebMethod
    public @WebResult(name="log") List<String> ventaEntradaLog(){
        return log;
    }

}
