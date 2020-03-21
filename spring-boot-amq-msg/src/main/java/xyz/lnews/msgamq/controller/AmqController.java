package xyz.lnews.msgamq.controller;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.*;

import javax.jms.*;

@RestController
public class AmqController {

    private String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private String Q_NAME = "LNEWS/Q";
    private String messageReceived="";
    private TextMessage textMessage;


    @RequestMapping("/")
    public String message(){
        return "Either /send or /receive";
    }

    @PostMapping("/send")
    public String sendMessageThroughQ(@RequestBody String message) throws Exception{
        JmsTemplate jmsTemplate = initialize();

        System.out.println(message);

        jmsTemplate.send(Q_NAME, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage tm = session.createTextMessage();
                tm.setText(message);
                return tm;
            }
        });

        return message;
    }

    @GetMapping("/receive")
    public String receiveMessageThroughQ() throws Exception{
        JmsTemplate jmsTemplate = initialize();

        Message message = jmsTemplate.receive(Q_NAME);
        if(message instanceof TextMessage) {
            textMessage = (TextMessage) message;
        }else{
            throw new Exception("Exception");
        }
        messageReceived = textMessage.getText();
        return "Message consumed::"+messageReceived;
    }

    private JmsTemplate initialize() {
        ConnectionFactory cf = new ActiveMQConnectionFactory(URL);
        JmsTemplate jmsTemplate = new JmsTemplate(cf);
        jmsTemplate.setSessionTransacted(false);
        jmsTemplate.setReceiveTimeout(5000);
        jmsTemplate.setDeliveryPersistent(false);

        return jmsTemplate;
    }

    @ExceptionHandler(value = Exception.class)
    public String throwException(){
        return "!!!Exception!!!";
    }
}
