package uy.edu.fing.middleware.obligatorio1.ws.handler;

import com.sun.xml.messaging.saaj.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

/**
 *
 * @author Farid
 */
public class SoapHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        final Boolean outInd = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outInd.booleanValue()) {
            try {
                
                Map<String, List<String>> map = (Map<String, List<String>>) context.get(MessageContext.HTTP_REQUEST_HEADERS);
                List<String> authHeadersList = map.get("Authorization");
                if(authHeadersList.isEmpty()){
                    throw new RuntimeException();
                }
                String authHeader = authHeadersList.get(0);
              
                Pattern p = Pattern.compile("basic (.+)",Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(authHeader);
                if(!m.matches()){
                    throw new RuntimeException();
                }
                String basicAuthValue = m.group(1);
                String decoded = Base64.base64Decode(basicAuthValue);
                if(!decoded.equals("ventas:ventas")){
                    throw new RuntimeException();
                }
                
            } catch (final Exception e) {
                String reason = "Authentication error";
                generateSOAPErrMessage(context, reason);
                return false;
            }
                
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {

        return false;
    }

    @Override
    public void close(MessageContext context) {

    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
    
    
     private void generateSOAPErrMessage(SOAPMessageContext context, String reason) {
       try {
          SOAPMessage msg = context.getMessage();
          msg.getSOAPPart().getEnvelope().getBody().removeContents();
          SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
          SOAPFault soapFault = soapBody.addFault();
          soapFault.setFaultString(reason);
          Map<String, List<String>> headers = (Map<String, List<String>>) context
                  .get(MessageContext.HTTP_RESPONSE_HEADERS);
          if (null == headers) {
              headers = new HashMap<String, List<String>>();
          }
          String headerKey = "WWW-Authenticate";
          String headerValue = "Basic realm=\"Ventas\"";
          headers.put(headerKey, Collections.singletonList(headerValue));
          context.put(MessageContext.HTTP_RESPONSE_HEADERS, headers);
          throw new SOAPFaultException(soapFault); 
       }
       catch(SOAPException e) { }
       
    }

}
