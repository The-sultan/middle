package uy.edu.middleware.obligatorio2.transformers;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import uy.edu.fing.middleware.obligatorio2.domain.PagoResponse;
  
public class PagoResponseTransformer extends AbstractMessageTransformer{
	
	@Override
	public PagoResponse transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		PagoResponse ret = new PagoResponse();
    	ret.setIdentificadorPago(Long.parseLong((String) message.getPayload()));
    	
    	return ret;
	}
}