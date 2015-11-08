package uy.edu.middleware.obligatorio2.transformers;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import uy.edu.fing.middleware.generated.amazonia.DatoReserva;
import uy.edu.fing.middleware.generated.amazonia.ReservaProductos;
import uy.edu.fing.middleware.obligatorio2.domain.Item;
  
public class ItemToReservaProductoTransformer extends AbstractMessageTransformer{
	
	@Override
	public List<DatoReserva> transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
    	DatoReserva ret = new DatoReserva();
    	ret.setCantidad(((Item)message.getPayload()).getCantidad());
    	ret.setIdProducto(((Item)message.getPayload()).getIdProducto());
    	List<DatoReserva> requestList = new ArrayList<DatoReserva>();
    	requestList.add(ret);
    	ReservaProductos req = new ReservaProductos();
    	
    	return requestList;
	}
}