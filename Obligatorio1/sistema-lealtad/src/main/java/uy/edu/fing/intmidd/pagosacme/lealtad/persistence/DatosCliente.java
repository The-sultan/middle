package uy.edu.fing.intmidd.pagosacme.lealtad.persistence;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import uy.edu.fing.intmidd.pagosacme.lealtad.domain.DatosLealtad;
import uy.edu.fing.intmidd.pagosacme.lealtad.persistence.DatosCliente.HistoriaEntry.CodigoMoneda;

public class DatosCliente {

	public static class HistoriaEntry {
		 
		public static enum CodigoMoneda {
			UYU("UYU", 0.1),
			USD("USD", 0.3);
			 
			public final String value;
			public final double tasaPuntos;
			 
			private CodigoMoneda(String value, double tasaPuntos) {
				this.value = value;
				this.tasaPuntos = tasaPuntos;
			}
		}
		 
		private Date fechaHoraPago;
		private Double monto;
		private CodigoMoneda codigoMoneda;
		 
		public Date getFechaHoraPago() {
			return fechaHoraPago;
		}
		public void setFechaHoraPago(Date fechaHoraPago) {
			this.fechaHoraPago = fechaHoraPago;
		}
		
		public Double getMonto() {
			return monto;
		}
		public void setMonto(double monto) {
			this.monto = monto;
		}
		
		public CodigoMoneda getCodigoMoneda() {
			return codigoMoneda;
		}
		public void setCodigoMoneda(CodigoMoneda codigoMoneda) {
			this.codigoMoneda = codigoMoneda;
		}
	 }
	 
	 private Long idCliente;
	 private List<HistoriaEntry> historial = new LinkedList<>();
	 private long puntosAcumulados = 0;
	 
	public Long getIdCliente() {
		return idCliente;
	}
	
	public Long getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public List<HistoriaEntry> getHistorial() {
		return historial;
	}
	
	public void agregar(DatosLealtad dl) {
		
		Validate.isTrue(dl.getIdCliente().equals(idCliente) || (idCliente == null), "No coincide idCliente: %s <> %s", idCliente, dl.getIdCliente());
		
		if (idCliente == null) {
			idCliente = dl.getIdCliente();
		}
		
		HistoriaEntry he = new HistoriaEntry();
		he.setFechaHoraPago(dl.getFechaHoraCobro());
		he.setMonto(dl.getMonto());
		he.setCodigoMoneda(Enum.valueOf(CodigoMoneda.class, dl.getCodigoMoneda()));
		historial.add(he);
		
		puntosAcumulados += dl.getMonto() * he.getCodigoMoneda().tasaPuntos;
	}
}
