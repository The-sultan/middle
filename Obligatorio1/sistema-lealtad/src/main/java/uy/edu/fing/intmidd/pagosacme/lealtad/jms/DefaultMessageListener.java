package uy.edu.fing.intmidd.pagosacme.lealtad.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.apache.activemq.command.ActiveMQTextMessage;

import uy.edu.fing.intmidd.pagosacme.lealtad.domain.DatosLealtad;
import uy.edu.fing.intmidd.pagosacme.lealtad.persistence.Storing;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultMessageListener implements MessageListener {

	private ObjectMapper objectMapper = new ObjectMapper();

	public void onMessage(Message msg) {
		
		System.out.println("Message received: " + msg);
		
		if (msg instanceof TextMessage) {
			TextMessage txtmsg = (TextMessage) msg;
		    
		    try {
		    	DatosLealtad dl = objectMapper.readValue(txtmsg.getText(), DatosLealtad.class);
		    	Storing.agregar(dl);
		    } catch (Exception ex) {
//		      LOG.error("Failed to process message due to: " + e + ". Message: "+ message,e);
		    	System.out.println("Failed to process message due to: " + ex + ". Message: "+ msg);
		    	return;
		    }
		} else {
//		    LOG.warn("Ignoring invalid message: " + message);
			 System.out.println("Ignoring invalid message: " + msg);
		}
		
		// If no error send ACK for removing message from queue
		try {
			msg.acknowledge();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
