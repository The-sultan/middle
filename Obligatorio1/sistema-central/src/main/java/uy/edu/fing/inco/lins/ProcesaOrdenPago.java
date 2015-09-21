package uy.edu.fing.inco.lins;

import uy.edu.fing.inco.lins.domain.VentaEntradasMOM;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.ServiceActivator;

import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.Pago;
import uy.edu.fing.inco.lins.generated.partnerfactura.FacturaNoEncontrada_Exception;
import uy.edu.fing.inco.lins.generated.partnerfactura.MonedaNoEncontrada_Exception;
import uy.edu.fing.inco.lins.generated.partnerfactura.PagoFacturaEndpointService;
import uy.edu.fing.inco.lins.generated.partnerfactura.PagoFacturaRequest;
import uy.edu.fing.inco.lins.generated.partnerventa.CantidadInsuficienteEntradas_Exception;
import uy.edu.fing.inco.lins.generated.partnerventa.LoginIncorrecto_Exception;
import uy.edu.fing.inco.lins.generated.partnerventa.VentaEntradasEndpointService;

/**
 * @author Mauricio Vignale
 */
//@Component
public class ProcesaOrdenPago {
	private static final Logger logger = Logger.getLogger(ProcesaOrdenPago.class);


	@ServiceActivator(inputChannel="serviceEntradas", outputChannel="ticketChannel")
	public ConfirmacionPago entradas(VentaEntradasMOM entradaItem) {
		ConfirmacionPago cp = new ConfirmacionPago();
		cp.setIdentificadorPago(entradaItem.getIdentificadorPago());
		List<String> result = null;
		VentaEntradasEndpointService servicioVentas = new VentaEntradasEndpointService();
		try {
			result = servicioVentas.getVentaEntradasEndpointPort().ventaEntradas(entradaItem.getCantEntradas(), entradaItem.getMonedaID(), entradaItem.getMonto(), entradaItem.getFecha());
		} catch (CantidadInsuficienteEntradas_Exception | LoginIncorrecto_Exception
				| uy.edu.fing.inco.lins.generated.partnerventa.MonedaNoEncontrada_Exception e) {
			cp.setResultado("ERROR");
			cp.setDescripcion(e.getLocalizedMessage());
			return cp;
		}
		cp.setResultado("OK");
		cp.setDescripcion(result.toString());
		return new ConfirmacionPago();

	}

	@ServiceActivator(inputChannel="serviceFacturas", outputChannel="ticketChannel")
	public ConfirmacionPago facturas(PagoFacturaRequest facturaItem) {
		ConfirmacionPago cp = new ConfirmacionPago();
		cp.setIdentificadorPago(facturaItem.getFacturaID());
		Integer result = null;
		PagoFacturaEndpointService servicioFacturas = new PagoFacturaEndpointService();
		try {
			result = servicioFacturas.getPagoFacturaEndpointPort().pagoFactura(facturaItem);
		} catch (NumberFormatException | FacturaNoEncontrada_Exception | MonedaNoEncontrada_Exception e) {
			cp.setResultado("ERROR");
			cp.setDescripcion(e.getLocalizedMessage());
			return cp;
		}
		cp.setResultado("OK");
		cp.setDescripcion(result.toString());
		return cp;


	}

	@ServiceActivator(inputChannel="csvOffline", outputChannel="ticketChannel")
	public ConfirmacionPago offline(Pago pagoItem) {
		return new ConfirmacionPago();
		// aca se engancha la logica del CSV de pago offline
//			logger.info(Thread.currentThread().getName()
//					+ " Pago del Item #" + pagoOffline.incrementAndGet() + " de la orden #"
//					+ pagoItem.getOrdenId() + ": " + pagoItem);
//					return new TicketPago(pagoItem.getOrdenId(), pagoItem.getTipoPago());

	}
}
