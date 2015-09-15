package uy.edu.fing.middleware.obligatorio1.ws.domain;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 *
 * @author Farid
 */
public class PagoFacturaRequest {
    private long facturaID;
    private short monedaID;
    private BigDecimal monto;
    private GregorianCalendar fecha;

    public long getFacturaID() {
        return facturaID;
    }

    public void setFacturaID(long facturaID) {
        this.facturaID = facturaID;
    }

    public short getMonedaID() {
        return monedaID;
    }

    public void setMonedaID(short monedaID) {
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
