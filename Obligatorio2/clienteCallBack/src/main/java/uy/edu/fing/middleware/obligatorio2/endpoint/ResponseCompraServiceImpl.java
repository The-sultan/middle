package uy.edu.fing.middleware.obligatorio2.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.apache.log4j.Logger;

import uy.edu.fing.middleware.obligatorio2.interfaces.ResponseCompraService;


@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.interfaces.ResponseCompraService",
			serviceName="ResponseCompraService")
public class ResponseCompraServiceImpl implements ResponseCompraService{

	private static final Logger logger = Logger.getLogger(ResponseCompraServiceImpl.class);
	
	@Override
	@WebMethod
	public void responseCompra(@WebParam (name = "compraResponse")@XmlElement(required=true) String resultado) {
		
		logger.info("Respuesta : " + resultado);
		System.out.println("Respuesta : " + resultado);
		
	}
	
	

}
