package uy.edu.fing.inco.lins;

import java.io.Serializable;

/**
 * @author Mauricio Vignale
 */
public class TicketPago implements Serializable{

	private static final long serialVersionUID = 1L;

	private TipoPago tipoPago;

	private int ordenId;

	public TicketPago() {}

	public TicketPago(int ordenId, TipoPago tipoPago) {
		this.ordenId = ordenId;
		this.tipoPago = tipoPago;

	}

	public int getOrdenId() {
		return ordenId;
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


	@Override
	public String toString() {
		return " Orden "+ ordenId + " tipoPago "+tipoPago;
	}

}
