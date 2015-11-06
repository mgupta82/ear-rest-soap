package com.unica.entapp.jms;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.NumericNode;
import com.unica.entapp.model.NumberPair;

@Service("gcdMessenger")
public class GcdMessenger {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(final NumberPair numberPair){
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(numberPair);
                objectMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
                return objectMessage;
            }
        });
	}
	
	public NumberPair receive() throws JMSException{
		ObjectMessage objectMessage = (ObjectMessage)jmsTemplate.receive();
		NumberPair numberPair  =(NumberPair) objectMessage.getObject();
		return numberPair;
	}	

}
