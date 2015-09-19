
package uy.edu.fing.inco.lins;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;


public class VentaEntradasMOM {
	
	private	 long identificadorPago;
	private	 short cantEntradas;
	private	 String monedaID;
	private	 BigDecimal monto;
	private	 XMLGregorianCalendar fecha;


    public short getCantEntradas() {
        return cantEntradas;
    }


    public void setCantEntradas(short value) {
        this.cantEntradas = value;
    }


    public String getMonedaID() {
        return monedaID;
    }


    public void setMonedaID(String value) {
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


	public long getIdentificadorPago() {
		return identificadorPago;
	}


	public void setIdentificadorPago(long identificadorPago) {
		this.identificadorPago = identificadorPago;
	}

}
