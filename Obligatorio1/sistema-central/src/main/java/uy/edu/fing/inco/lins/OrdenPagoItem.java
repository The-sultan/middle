package uy.edu.fing.inco.lins;


import java.io.Serializable;

/**
 * @author Mauricio Vignale
 */
public class OrdenPagoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoPago tipoPago;

	private int ordenId;

	public OrdenPagoItem() {}

	public OrdenPagoItem(int ordenId, TipoPago tipoPago) {
		this.ordenId = ordenId;
		this.tipoPago = tipoPago;
	}

	public int getOrdenId() {
		return this.ordenId;
	}

	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}


	public TipoPago getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String toString() {
		return "#Orden " +this.ordenId + " tipo " + this.tipoPago;
	}

}
