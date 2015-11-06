package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import uy.edu.fing.middleware.obligatorio2.domain.Orden;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService;


//@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService",
//			serviceName="CompraService")
@Service(value="compraService")
public class CompraServiceImpl implements CompraService{
	
	private static final Logger logger = Logger.getLogger(CompraServiceImpl.class);

	@Override
	@WebMethod
	public void compra(@WebParam (name = "ordenRequest")@XmlElement(required=true) Orden orden) {
		logger.info(orden);
		
		
	}
	
	

}
