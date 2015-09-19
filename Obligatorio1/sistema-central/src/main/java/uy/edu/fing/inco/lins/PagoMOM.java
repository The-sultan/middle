
package uy.edu.fing.inco.lins;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

public class PagoMOM {

    private String codigoMoneda;
    private List<String> datoAdicional;
    private long identificadorPago;
    private double monto;
    private String nombreGestion;
    private XMLGregorianCalendar fechaPago;



	public String getCodigoMoneda() {
        return codigoMoneda;
    }


    public void setCodigoMoneda(String value) {
        this.codigoMoneda = value;
    }

  
    public List<String> getDatoAdicional() {
        if (datoAdicional == null) {
            datoAdicional = new ArrayList<String>();
        }
        return this.datoAdicional;
    }


    public long getIdentificadorPago() {
        return identificadorPago;
    }


    public void setIdentificadorPago(long value) {
        this.identificadorPago = value;
    }


    public double getMonto() {
        return monto;
    }


    public void setMonto(double value) {
        this.monto = value;
    }


    public String getNombreGestion() {
        return nombreGestion;
    }


    public void setNombreGestion(String value) {
        this.nombreGestion = value;
    }
    
    public XMLGregorianCalendar getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(XMLGregorianCalendar fechaPago) {
		this.fechaPago = fechaPago;
	}


	public void setDatoAdicional(List<String> datoAdicional) {
		this.datoAdicional = datoAdicional;
	}

}
