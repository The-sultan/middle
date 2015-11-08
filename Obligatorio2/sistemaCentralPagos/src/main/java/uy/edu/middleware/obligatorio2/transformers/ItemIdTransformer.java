package uy.edu.middleware.obligatorio2.transformers;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import uy.edu.fing.middleware.generated.amazonia.DatoReserva;
import uy.edu.fing.middleware.generated.amazonia.ReservaProductos;
import uy.edu.fing.middleware.obligatorio2.domain.Item;
  
public class ItemIdTransformer extends AbstractMessageTransformer{
	
	@Override
	public Long transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
    	
    	
    	return null;
	}
}