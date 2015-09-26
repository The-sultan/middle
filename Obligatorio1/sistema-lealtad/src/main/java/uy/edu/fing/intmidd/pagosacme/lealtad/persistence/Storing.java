package uy.edu.fing.intmidd.pagosacme.lealtad.persistence;

import java.util.HashMap;
import java.util.Map;

import uy.edu.fing.intmidd.pagosacme.lealtad.domain.DatosLealtad;

/**
 * @author Oscar
 *
 */
public class Storing {

	private static final Map<Long, DatosCliente> clientes = new HashMap<>();
	
	private Storing() {
	}
	
	public synchronized static void agregar(DatosLealtad dl) {
		
		DatosCliente dc = clientes.get(dl.getIdCliente());
		if (dc == null) {
			dc = new DatosCliente();
			clientes.put(dl.getIdCliente(), dc);
		}
		
		dc.agregar(dl);
	}
	
	public synchronized static DatosCliente obtener(Long idCliente) {
		return clientes.get(idCliente);
	}
}
