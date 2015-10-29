package uy.edu.fing.middleware.obligatorio2.servicio;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.edu.fing.middleware.obligatorio2.domain.DatoEntrada;


@Path("/")
@WebService(name="pagosYaService")
public interface PagosYaRestService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPagos(DatoEntrada pago);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHello();
	
}
