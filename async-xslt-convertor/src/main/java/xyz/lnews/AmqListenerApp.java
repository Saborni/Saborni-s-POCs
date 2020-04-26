package xyz.lnews;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import xyz.lnews.listener.AsyncMessageListener;

import javax.jms.*;

public class AmqListenerApp {

    private String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private String Q_NAME = "LNEWS/Q";

    public void listen() throws Exception {

        ConnectionFactory cf = new ActiveMQConnectionFactory(URL);
        Connection connection = cf.createConnection();
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(Q_NAME);

        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new AsyncMessageListener("Consumer"));
        connection.start();
    }

}