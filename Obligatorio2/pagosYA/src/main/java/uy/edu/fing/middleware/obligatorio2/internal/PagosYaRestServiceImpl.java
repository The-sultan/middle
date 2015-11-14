package uy.edu.fing.middleware.obligatorio2.internal;

import java.util.Calendar;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import uy.edu.fing.middleware.obligatorio2.domain.DatoEntrada;
import uy.edu.fing.middleware.obligatorio2.servicio.PagosYaRestService;

public class PagosYaRestServiceImpl implements PagosYaRestService{

	private static final Logger logger = Logger.getLogger(PagosYaRestServiceImpl.class);
	
	@Override
	public Response addPagos(DatoEntrada pago) {
		try{
            if(pago.getNroTarjeta().equals("666"))
                throw new RuntimeException("Tarjeta invalida");
			logger.info("Nuevo pago : " + pago);
           // System.out.println("Nuevo Pago " + pago);
			Long idTrans = Calendar.getInstance().getTimeInMillis();
			logger.info("Id Transaccion  : " + idTrans);
			//System.out.println("Id Transaccion " + idTrans);
			return Response.ok(idTrans).build();
		}catch (Exception e) {
			logger.info("Error en el pago : " + pago);
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@Override
	public Response sayHello() {
		String respuesta = new String("sayHello ");
		System.out.println("sayHello ");		
		return Response.ok(respuesta).build();
	}
	
	

}
