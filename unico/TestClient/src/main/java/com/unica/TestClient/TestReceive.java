package com.unica.TestClient;

import java.util.Properties;

import javax.jms.DeliveryMode;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TestReceive {
	
	public static void main(String args[]){
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
		try{
		// Create a ConnectionFactory
		javax.naming.Context ctx = new InitialContext(props);
		
		QueueConnectionFactory connectionFactory = (QueueConnectionFactory)ctx.lookup("ConnectionFactory");
		QueueConnection connection = connectionFactory.createQueueConnection();
		connection.start();
		
		QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = (Queue)ctx.lookup("dynamicQueues/com.unica.gcd.input");
		QueueReceiver receiver = session.createReceiver(queue);

		
		TextMessage message = (TextMessage) receiver.receive();
		System.err.println(message);
		
		session.close();
		connection.close();
		
		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	

}
