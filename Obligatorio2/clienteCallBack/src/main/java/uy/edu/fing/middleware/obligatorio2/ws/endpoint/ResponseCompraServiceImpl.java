package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import uy.edu.fing.middleware.obligatorio2.ws.interfaces.ResponseCompraService;

@org.apache.cxf.interceptor.InInterceptors (interceptors = {"org.apache.cxf.interceptor.LoggingInInterceptor" })
//@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.interfaces.ResponseCompraService",
//			serviceName="ResponseCompraService")
public class ResponseCompraServiceImpl implements ResponseCompraService{

	private static final Logger logger = Logger.getLogger(ResponseCompraServiceImpl.class);
	

	@Oneway
	public void callBack(@WebParam(name="return") String callbackMessage){
		//System.out.println("Recieved callback message " + callbackMessage);
		logger.info("Recibimos mensaje callback  " + callbackMessage);
	}
	
	

}
