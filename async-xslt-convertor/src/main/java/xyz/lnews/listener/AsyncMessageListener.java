package xyz.lnews.listener;

import xyz.lnews.converter.XsltConverter;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class AsyncMessageListener implements MessageListener {
    private String consumerName;

    public AsyncMessageListener(String consumerName) {
        this.consumerName = consumerName;
    }

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        XsltConverter converter = new XsltConverter();
        try {
            String xmlMessage = textMessage.getText();
            converter.transformToText(xmlMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
