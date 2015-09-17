package uy.edu.fing.inco.lins;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mauricio Vignale
 */
public class RespuestaTicketPago implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final String SEPARADOR = "-----------------------";

	private List<TicketPago> tickets;

	private int ordenId;

	public RespuestaTicketPago() {}

	public RespuestaTicketPago(List<TicketPago> tickets) {
		this.tickets = tickets;
		this.ordenId = tickets.get(0).getOrdenId();
	}


	public int getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}

	public List<TicketPago> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketPago> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(SEPARADOR + "\n");
		buffer.append("Orden #" + getOrdenId() + "\n");
		for (TicketPago ticket : getTickets()) {
			buffer.append(ticket);
			buffer.append("\n");
		}
		buffer.append(SEPARADOR + "\n");
		return buffer.toString();
	}

}
