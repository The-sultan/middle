package uy.edu.fing.middleware.obligatorio1.ws.domain;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Farid
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class VentaEntradasRequest {
    @XmlElement(required=true) short cantEntradas;
    @XmlElement(required=true) String monedaID;
    @XmlElement(required=true) BigDecimal monto;
    @XmlElement(required=true) GregorianCalendar fecha;

    public short getCantEntradas() {
        return cantEntradas;
    }

    public void setCantEntradas(short cantEntradas) {
        this.cantEntradas = cantEntradas;
    }

    public String getMonedaID() {
        return monedaID;
    }

    public void setMonedaID(String monedaID) {
        this.monedaID = monedaID;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
    
    
}
