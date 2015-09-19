
package uy.edu.fing.inco.lins;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

public class PagoFacturaMOM {

    private long facturaID;
    private short monedaID;
    private BigDecimal monto;
    private XMLGregorianCalendar fecha;


    public long getFacturaID() {
        return facturaID;
    }


    public void setFacturaID(long value) {
        this.facturaID = value;
    }


    public short getMonedaID() {
        return monedaID;
    }


    public void setMonedaID(short value) {
        this.monedaID = value;
    }


    public BigDecimal getMonto() {
        return monto;
    }


    public void setMonto(BigDecimal value) {
        this.monto = value;
    }


    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

}
