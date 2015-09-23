package uy.edu.fing.inco.lins.ws;

import java.util.HashMap;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.GenericMessage;

import uy.edu.fing.inco.lins.PagoCliente;

import uy.edu.fing.inco.lins.generated.ServicioRecepcionPagos;
import uy.edu.fing.inco.lins.generated.ConfirmacionTransaccion;
import uy.edu.fing.inco.lins.generated.TransaccionPago;
import uy.edu.fing.inco.lins.generated.ObjectFactory;

@WebService(name = "ServicioRecepcionPagos", targetNamespace = "http://services.middleware.fing.org/")
@XmlSeeAlso({ObjectFactory.class})
public class ServicioRecepcionPagosImpl implements ServicioRecepcionPagos {

    @Autowired
    private PagoCliente disparador;

    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "recepcionPagos", targetNamespace = "http://services.middleware.fing.org/", className = "uy.edu.fing.inco.lins.generated.RecepcionPagos")
    @ResponseWrapper(localName = "recepcionPagosResponse", targetNamespace = "http://services.middleware.fing.org/", className = "uy.edu.fing.inco.lins.generated.RecepcionPagosResponse")
    @Action(input = "http://services.middleware.fing.org/ServicioRecepcionPagos/recepcionPagosRequest", output = "http://services.middleware.fing.org/ServicioRecepcionPagos/recepcionPagosResponse")
    public ConfirmacionTransaccion recepcionPagos(@WebParam(name = "arg0", targetNamespace = "") TransaccionPago arg0) {
        Map<String,Object> headers = new HashMap<>();
        headers.put("idClient",arg0.getIdentificadorCliente());
        GenericMessage<TransaccionPago> message = new GenericMessage<>(arg0, headers);
        ConfirmacionTransaccion ct = disparador.despacharOrden(message);
        return ct;
    }

}
