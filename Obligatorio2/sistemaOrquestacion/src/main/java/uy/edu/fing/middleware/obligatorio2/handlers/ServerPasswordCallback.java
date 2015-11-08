package uy.edu.fing.middleware.obligatorio2.handlers;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.log4j.Logger;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ServerPasswordCallback implements CallbackHandler {

	private static final Logger logger = Logger.getLogger(ServerPasswordCallback.class);
	
	@Override
	public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException {
		System.out.println("#################################");
		logger.info("Vamos a validar la firma");
		for (int i = 0; i < callbacks.length; i++) {
			  System.out.println("#################################");
			  WSPasswordCallback pwcb = (WSPasswordCallback)callbacks[i];
	          String id = pwcb.getIdentifier();
	          int usage = pwcb.getUsage();
	          if (usage == WSPasswordCallback.DECRYPT || usage == WSPasswordCallback.SIGNATURE) {
	                // used to retrieve password for private key
	                if ("testkey".equals(id)) {
	                    pwcb.setPassword("clientpass");
	                }

	           }
	      }
	    
		
	}
	
}
