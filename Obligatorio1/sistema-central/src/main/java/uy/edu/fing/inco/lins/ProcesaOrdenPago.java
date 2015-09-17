package uy.edu.fing.inco.lins;

import java.util.concurrent.atomic.AtomicInteger;

import uy.edu.fing.inco.lins.TicketPago;
import uy.edu.fing.inco.lins.OrdenPagoItem;
import uy.edu.fing.inco.lins.TempConverter;
import org.apache.log4j.Logger;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.ws.SimpleWebServiceOutboundGateway;
import org.springframework.integration.ws.WebServiceHeaders;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	public TicketPago entradas(OrdenPagoItem ordenPagoItem) {
		// aca se engancha la logica del WS partner de Entradas
		AbstractApplicationContext ctx =
			new ClassPathXmlApplicationContext("/META-INF/spring/integration/sistema-central.xml", ProcesaOrdenPago.class);

			TempConverter converter = (TempConverter)ctx.getBean("tempTest");
			logger.info(Thread.currentThread().getName()
					+ "Pago del Item # " + pagoEntradas.incrementAndGet() + " de la orden #"
					+ ordenPagoItem.getOrdenId() + ": " + ordenPagoItem +" LLAMADA A WS " + converter.fahrenheitToCelcius(68.0f));
			return new TicketPago(ordenPagoItem.getOrdenId(), ordenPagoItem.getTipoPago());

	}

	@ServiceActivator(inputChannel="partnerFacturas", outputChannel="ticketChannel")
	public TicketPago facturas(OrdenPagoItem ordenPagoItem) {
		// aca se engancha la logica del WS partner de Facturas

			logger.info(Thread.currentThread().getName()
					+ "Pago del Item # " + pagoFacturas.incrementAndGet() + " de la orden #"
					+ ordenPagoItem.getOrdenId() + ": " + ordenPagoItem);
					return new TicketPago(ordenPagoItem.getOrdenId(), ordenPagoItem.getTipoPago());

	}

	@ServiceActivator(inputChannel="partnerOffline", outputChannel="ticketChannel")
	public TicketPago offline(OrdenPagoItem ordenPagoItem) {
		// aca se engancha la logica del CSV de pago offline
			logger.info(Thread.currentThread().getName()
					+ " Pago del Item #" + pagoOffline.incrementAndGet() + " de la orden #"
					+ ordenPagoItem.getOrdenId() + ": " + ordenPagoItem);
					return new TicketPago(ordenPagoItem.getOrdenId(), ordenPagoItem.getTipoPago());

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
