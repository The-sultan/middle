
package uy.edu.fing.inco.lins;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uy.edu.fing.inco.lins.generated.ServicioRecepcionPagos;
import uy.edu.fing.inco.lins.generated.ConfirmacionTransaccion;
import uy.edu.fing.inco.lins.generated.TransaccionPago;
import uy.edu.fing.inco.lins.generated.ObjectFactory;

@WebService(name = "ServicioRecepcionPagos", targetNamespace = "http://services.middleware.fing.org/")
@XmlSeeAlso({ ObjectFactory.class })
public class ServicioRecepcionPagosImpl implements ServicioRecepcionPagos {

	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "recepcionPagos", targetNamespace = "http://services.middleware.fing.org/", className = "uy.edu.fing.inco.lins.generated.RecepcionPagos")
	@ResponseWrapper(localName = "recepcionPagosResponse", targetNamespace = "http://services.middleware.fing.org/", className = "uy.edu.fing.inco.lins.generated.RecepcionPagosResponse")
	@Action(input = "http://services.middleware.fing.org/ServicioRecepcionPagos/recepcionPagosRequest", output = "http://services.middleware.fing.org/ServicioRecepcionPagos/recepcionPagosResponse")
	public ConfirmacionTransaccion recepcionPagos(@WebParam(name = "arg0", targetNamespace = "") TransaccionPago arg0) {
		
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/integration/sistema-central.xml", this.getClass());
		PagoCliente disparador = (PagoCliente) ctx.getBean("pago");
		ConfirmacionTransaccion ct = disparador.despacharOrden(arg0);
		return ct;
		
	}

}
