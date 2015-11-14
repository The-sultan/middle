package uy.edu.fing.middleware.obligatorio2.ws.endpoint;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import uy.edu.fing.middleware.obligatorio2.domain.Item;

import uy.edu.fing.middleware.obligatorio2.domain.Orden;
import uy.edu.fing.middleware.obligatorio2.pagosYa.generated.Pago;
import uy.edu.fing.middleware.obligatorio2.pagosYa.generated.PagoResponse;
import uy.edu.fing.middleware.obligatorio2.pagosYa.generated.PagosRestService;
import uy.edu.fing.middleware.obligatorio2.pagosYa.generated.PagosRestServiceService;
import uy.edu.fing.middleware.obligatorio2.stockAmazonia.generated.AmazoniaResponse;
import uy.edu.fing.middleware.obligatorio2.stockAmazonia.generated.StockAmazoniaService;
import uy.edu.fing.middleware.obligatorio2.stockAmazonia.generated.StockAmazoniaServiceService;
import uy.edu.fing.middleware.obligatorio2.stockEPuerto.generated.ReservaEPuerto;
import uy.edu.fing.middleware.obligatorio2.stockEPuerto.generated.StockEPuertoService;
import uy.edu.fing.middleware.obligatorio2.stockEPuerto.generated.StockEPuertoServiceService;
import uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService;

//@WebService(endpointInterface="uy.edu.fing.middleware.obligatorio2.ws.interfaces.CompraService",
//			serviceName="CompraService")
@Service(value = "compraService")
public class CompraServiceImpl implements CompraService {

    private static final Logger logger = Logger.getLogger(CompraServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    @WebMethod
    public String compra(@WebParam(name = "ordenRequest") @XmlElement(required = true) Orden orden) {
        logger.info(orden);
        
        StockEPuertoService epuertoService = new StockEPuertoServiceService().getStockEPuertoServicePort();
        StockAmazoniaService stockLocalService = new StockAmazoniaServiceService().getStockAmazoniaServicePort();
        PagosRestService pagoService = new PagosRestServiceService().getPagosRestServicePort();

        Double total = 0d;
        for (Item item : orden.getProductos()) {
            uy.edu.fing.middleware.obligatorio2.stockAmazonia.generated.Item itemStockLocal = 
                    new uy.edu.fing.middleware.obligatorio2.stockAmazonia.generated.Item();
                    
            itemStockLocal.setCantidad(item.getCantidad());
            itemStockLocal.setIdProducto(item.getIdProducto());
            AmazoniaResponse response = stockLocalService.stock(itemStockLocal);
            if (response.getCodigo().equals("Error")) {
                ReservaEPuerto reservaEPuerto = new ReservaEPuerto();
                reservaEPuerto.setCantidad(item.getCantidad());
                reservaEPuerto.setIdCompra(orden.getIdCompra());
                reservaEPuerto.setIdProducto(item.getIdProducto());
                epuertoService.stock(reservaEPuerto);
            }
            total += item.getCantidad() * item.getPrecioUnitario();
        }
        Pago pago = new Pago();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        XMLGregorianCalendar date;
        try {
            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException ex) {
            //esto nunca va a pasar porque la date se crea por codigo
            date = null;
        }
        pago.setFechaHora(date);
        pago.setIdCompra(Long.valueOf(orden.getIdCompra()));
        pago.setMonto(total);
        pago.setNroTarjeta(String.valueOf(orden.getNroTarjeta()));
        try{
            PagoResponse response = pagoService.pagoYa(pago);
            if (response.getIdentificadorPago() != null) {
                return "OK";
            }else{
                this.sendJmsMsg(orden.getIdCompra());
                return "Error";
            }
        }
        catch(Exception ex){
            this.sendJmsMsg(orden.getIdCompra());
            return "Error";
        }

        
        
                

    }
    
    private void sendJmsMsg(final String text) {

        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                return message;
            }
        });
    }

    
}
