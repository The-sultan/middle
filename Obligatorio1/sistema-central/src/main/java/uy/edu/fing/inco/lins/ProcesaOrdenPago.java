package uy.edu.fing.inco.lins;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.ws.SimpleWebServiceOutboundGateway;
import org.springframework.integration.ws.WebServiceHeaders;
import org.springframework.stereotype.Component;

import uy.edu.fing.inco.lins.generated.ConfirmacionPago;
import uy.edu.fing.inco.lins.generated.Pago;

/**
 * @author Mauricio Vignale
 */
@Component
public class ProcesaOrdenPago {
	private static final Logger logger = Logger.getLogger(ProcesaOrdenPago.class);

	private AtomicInteger pagoEntradas = new AtomicInteger();

	private AtomicInteger pagoFacturas = new AtomicInteger();

	private AtomicInteger pagoOffline = new AtomicInteger();


	@ServiceActivator(inputChannel="partnerEntradas", outputChannel="ticketChannel")
	public ConfirmacionPago entradas(Pago pagoItem) {
		// aca se engancha la logica del WS partner de Entradas
		
			return new ConfirmacionPago();

	}

	@ServiceActivator(inputChannel="partnerFacturas", outputChannel="ticketChannel")
	public ConfirmacionPago facturas(Pago pagoItem) {
		return new ConfirmacionPago();
		// aca se engancha la logica del WS partner de Facturas

//			logger.info(Thread.currentThread().getName()
//					+ "Pago del Item # " + pagoFacturas.incrementAndGet() + " de la orden #"
//					+ pagoItem.getOrdenId() + ": " + pagoItem);
//					return new TicketPago(pagoItem.getOrdenId(), pagoItem.getTipoPago());

	}

	@ServiceActivator(inputChannel="partnerOffline", outputChannel="ticketChannel")
	public ConfirmacionPago offline(Pago pagoItem) {
		return new ConfirmacionPago();
		// aca se engancha la logica del CSV de pago offline
//			logger.info(Thread.currentThread().getName()
//					+ " Pago del Item #" + pagoOffline.incrementAndGet() + " de la orden #"
//					+ pagoItem.getOrdenId() + ": " + pagoItem);
//					return new TicketPago(pagoItem.getOrdenId(), pagoItem.getTipoPago());

	}

  @Bean
  public IntegrationFlow convert() {
      return f -> f
        .transform(payload ->
              "<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/webservices/\">"
            +     "<Fahrenheit>" + payload +"</Fahrenheit>"
            + "</FahrenheitToCelsius>")
        .enrichHeaders(h -> h
            .header(WebServiceHeaders.SOAP_ACTION,
                "http://www.w3schools.com/webservices/FahrenheitToCelsius"))
        .handle(new SimpleWebServiceOutboundGateway(
            "http://www.w3schools.com/webservices/tempconvert.asmx"))
        .transform(Transformers.xpath("/*[local-name()=\"FahrenheitToCelsiusResponse\"]"
            + "/*[local-name()=\"FahrenheitToCelsiusResult\"]"));
  }
}
