package uy.edu.middleware.obligatorio2.transformers;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import uy.edu.fing.middleware.generated.amazonia.DatoSalida;
import uy.edu.fing.middleware.obligatorio2.domain.AnularAmazoniaResponse;
  
public class AnularAmazoniaResponseTransformer extends AbstractMessageTransformer{
	
	@Override
	public AnularAmazoniaResponse transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
    	AnularAmazoniaResponse ret = new AnularAmazoniaResponse();
    	ret.setCodigo(((DatoSalida)message.getPayload()).getCodigo());
    	ret.setDescripcion(((DatoSalida)message.getPayload()).getDescripcion());
    	ret.setIdReserva(((DatoSalida)message.getPayload()).getIdReserva());

    	
    	return ret;
	}
}