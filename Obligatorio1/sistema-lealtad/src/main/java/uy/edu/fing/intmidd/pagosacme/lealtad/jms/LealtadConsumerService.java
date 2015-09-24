package uy.edu.fing.intmidd.pagosacme.lealtad.jms;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;

public class LealtadConsumerService {

	private static final String QUEUE_NAME = "queue.lealtad";
	
	private QueueConnectionFactory connFactory;
	private QueueConnection conn;
	
	public LealtadConsumerService(QueueConnectionFactory connFactory) {
		this.connFactory = connFactory;
	}
	
	public void start() throws JMSException {
		
		conn = connFactory.createQueueConnection();
		Session session = conn.createSession(true, 0);
		
		Queue queue = new ActiveMQQueue(QUEUE_NAME + "?consumer.exclusive=true&consumer.dispatchAsync=true&consumer.prefetchSize=10");
		MessageConsumer consumer = session.createConsumer(queue);
		
		DefaultMessageListener msgListener = new DefaultMessageListener();
		consumer.setMessageListener(msgListener);
		
		conn.start();
		
		System.out.println("LealtadConsumerService started");
	}
	
	public void stop() throws JMSException {
		
		try {
			conn.stop();
		} catch (Exception ex) {
			// Ignore
		}
		
		try {
			conn.close();
		} catch (Exception ex) {
			// Ignore
		}
		
		System.out.println("LealtadConsumerService stopped");
	}
}
