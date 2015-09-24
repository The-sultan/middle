
package uy.edu.fing.inco.lins.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

public class PagoMOM {

	public static enum FormaPago {
		Efectivo("E"),
		Cheque("C"),
		Debito("D");
		
		public final String value;
		
		private FormaPago(String value) {
			this.value = value;
		}
	}
	
	private Long idCliente;
	private Long nroSucursal;
	private FormaPago formaPago;
    private String codigoMoneda;
    private List<String> datoAdicional;
    private long identificadorPago;
    private double monto;
    private String nombreGestion;
    private XMLGregorianCalendar fechaPago;

    public Long getIdCliente() {
		return idCliente;
	}

    public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String value) {
        this.codigoMoneda = value;
    }

	public Long getNroSucursal() {
		return nroSucursal;
	}

	public void setNroSucursal(Long nroSucursal) {
		this.nroSucursal = nroSucursal;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
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
