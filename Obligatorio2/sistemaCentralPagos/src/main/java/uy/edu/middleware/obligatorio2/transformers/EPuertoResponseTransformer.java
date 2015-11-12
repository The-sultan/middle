package uy.edu.middleware.obligatorio2.transformers;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import uy.edu.fing.middleware.obligatorio2.domain.EPuertoResponse;
  
public class EPuertoResponseTransformer extends AbstractMessageTransformer{
	
	@Override
	public EPuertoResponse transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		EPuertoResponse ret = new EPuertoResponse();
    	ret.setIdCompra(((String[])message.getPayload())[0]);
    	ret.setIdReserva(((String[])message.getPayload())[1]);
		ret.setCodigo(((String[])message.getPayload())[2]);
    	ret.setDescripcion(((String[])message.getPayload())[3]);
    	return ret;
	}
}