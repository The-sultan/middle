
package uy.edu.fing.middleware.generated.amazonia;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uy.edu.fing.middleware.generated.amazonia package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AnularReserva_QNAME = new QName("http://interfaces.obligatorio2.middleware.fing.edu.uy/", "anularReserva");
    private final static QName _Exception_QNAME = new QName("http://interfaces.obligatorio2.middleware.fing.edu.uy/", "Exception");
    private final static QName _StockLocalLogResponse_QNAME = new QName("http://interfaces.obligatorio2.middleware.fing.edu.uy/", "stockLocalLogResponse");
    private final static QName _ReservaProductos_QNAME = new QName("http://interfaces.obligatorio2.middleware.fing.edu.uy/", "reservaProductos");
    private final static QName _StockLocalLog_QNAME = new QName("http://interfaces.obligatorio2.middleware.fing.edu.uy/", "stockLocalLog");
    private final static QName _AnularReservaResponse_QNAME = new QName("http://interfaces.obligatorio2.middleware.fing.edu.uy/", "anularReservaResponse");
    private final static QName _ReservaProductosResponse_QNAME = new QName("http://interfaces.obligatorio2.middleware.fing.edu.uy/", "reservaProductosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uy.edu.fing.middleware.generated.amazonia
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReservaProductosResponse }
     * 
     */
    public ReservaProductosResponse createReservaProductosResponse() {
        return new ReservaProductosResponse();
    }

    /**
     * Create an instance of {@link AnularReservaResponse }
     * 
     */
    public AnularReservaResponse createAnularReservaResponse() {
        return new AnularReservaResponse();
    }

    /**
     * Create an instance of {@link StockLocalLog }
     * 
     */
    public StockLocalLog createStockLocalLog() {
        return new StockLocalLog();
    }

    /**
     * Create an instance of {@link ReservaProductos }
     * 
     */
    public ReservaProductos createReservaProductos() {
        return new ReservaProductos();
    }

    /**
     * Create an instance of {@link StockLocalLogResponse }
     * 
     */
    public StockLocalLogResponse createStockLocalLogResponse() {
        return new StockLocalLogResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link AnularReserva }
     * 
     */
    public AnularReserva createAnularReserva() {
        return new AnularReserva();
    }

    /**
     * Create an instance of {@link DatoSalida }
     * 
     */
    public DatoSalida createDatoSalida() {
        return new DatoSalida();
    }

    /**
     * Create an instance of {@link DatoReserva }
     * 
     */
    public DatoReserva createDatoReserva() {
        return new DatoReserva();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnularReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.obligatorio2.middleware.fing.edu.uy/", name = "anularReserva")
    public JAXBElement<AnularReserva> createAnularReserva(AnularReserva value) {
        return new JAXBElement<AnularReserva>(_AnularReserva_QNAME, AnularReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.obligatorio2.middleware.fing.edu.uy/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StockLocalLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.obligatorio2.middleware.fing.edu.uy/", name = "stockLocalLogResponse")
    public JAXBElement<StockLocalLogResponse> createStockLocalLogResponse(StockLocalLogResponse value) {
        return new JAXBElement<StockLocalLogResponse>(_StockLocalLogResponse_QNAME, StockLocalLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservaProductos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.obligatorio2.middleware.fing.edu.uy/", name = "reservaProductos")
    public JAXBElement<ReservaProductos> createReservaProductos(ReservaProductos value) {
        return new JAXBElement<ReservaProductos>(_ReservaProductos_QNAME, ReservaProductos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StockLocalLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.obligatorio2.middleware.fing.edu.uy/", name = "stockLocalLog")
    public JAXBElement<StockLocalLog> createStockLocalLog(StockLocalLog value) {
        return new JAXBElement<StockLocalLog>(_StockLocalLog_QNAME, StockLocalLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnularReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.obligatorio2.middleware.fing.edu.uy/", name = "anularReservaResponse")
    public JAXBElement<AnularReservaResponse> createAnularReservaResponse(AnularReservaResponse value) {
        return new JAXBElement<AnularReservaResponse>(_AnularReservaResponse_QNAME, AnularReservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservaProductosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.obligatorio2.middleware.fing.edu.uy/", name = "reservaProductosResponse")
    public JAXBElement<ReservaProductosResponse> createReservaProductosResponse(ReservaProductosResponse value) {
        return new JAXBElement<ReservaProductosResponse>(_ReservaProductosResponse_QNAME, ReservaProductosResponse.class, null, value);
    }

}
