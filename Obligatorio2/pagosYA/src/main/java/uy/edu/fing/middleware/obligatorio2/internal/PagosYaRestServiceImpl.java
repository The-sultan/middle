package uy.edu.fing.middleware.obligatorio2.internal;

import java.util.Calendar;

import javax.ws.rs.core.Response;

import uy.edu.fing.middleware.obligatorio2.domain.DatoEntrada;
import uy.edu.fing.middleware.obligatorio2.servicio.PagosYaRestService;

public class PagosYaRestServiceImpl implements PagosYaRestService{

	@Override
	public Response addPagos(DatoEntrada pago) {
		try{
			System.out.println("Nuevo Pago " + pago);
			Long idTrans = Calendar.getInstance().getTimeInMillis();
			System.out.println("Id Transaccion " + idTrans);
			return Response.ok(idTrans).build();
		}catch (Exception e) {
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
