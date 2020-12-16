package com.Tacos.Tacos.messaging;

import com.Tacos.Tacos.DTO.OrderDto;
import com.Tacos.Tacos.models.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class JmsOrderMessagingService implements OrderMessagingService{

    private JmsTemplate jmsTemplate;

    public JmsOrderMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendOrder(OrderDto order){
        jmsTemplate.send(new MessageCreator(){
           @Override
           public Message createMessage(Session session)throws JMSException{
               return session.createObjectMessage(order);
           }
        });
    }
}
