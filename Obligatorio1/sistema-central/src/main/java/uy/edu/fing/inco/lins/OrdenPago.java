package uy.edu.fing.inco.lins;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mauricio Vignale
 */
public class OrdenPago implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<OrdenPagoItem> orderItems = new ArrayList<OrdenPagoItem>();

	private int id;

	public OrdenPago() {}

	public OrdenPago(int id) {
		this.id = id;
	}

	public void addItem(TipoPago tipoPago) {
		this.orderItems.add(new OrdenPagoItem(this.id, tipoPago));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrdenPagoItem> getItems() {
		return this.orderItems;
	}

	public void setItems(List<OrdenPagoItem> orderItems) {
		this.orderItems = orderItems;
	}
}
