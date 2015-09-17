package uy.edu.fing.inco.lins;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uy.edu.fing.inco.lins.PagoCliente;
import uy.edu.fing.inco.lins.TipoPago;
import uy.edu.fing.inco.lins.OrdenPago;

/**
 * @author Mauricio Vignale
 */
public class PagoDemoApp {

	public static void main(String[] args) {
		AbstractApplicationContext context =
			new ClassPathXmlApplicationContext("/META-INF/spring/integration/sistema-central.xml", PagoDemoApp.class);

		PagoCliente pagoDelCliente = (PagoCliente) context.getBean("pago");
		for (int i = 1; i <= 100; i++) {
			OrdenPago orden = new OrdenPago(i);
			orden.addItem(TipoPago.ENTRADAS);
			orden.addItem(TipoPago.FACTURA);
			pagoDelCliente.despacharOrden(orden);
		}
		context.close();
	}
}
