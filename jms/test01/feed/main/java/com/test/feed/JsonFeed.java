package com.test.feed;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.fluttercode.datafactory.impl.DataFactory;

import javax.jms.*;
import java.util.Date;

/**
 * Author: 胡荆陵
 * 发布消息
 */
public class JsonFeed{

    private static final String JMS_USER = "user";
    private static final String JMS_PASS = "user";
    private static final String JMS_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private boolean transacted = true;
    private String subject = "stock";

    public static void main(String[] args) {
        JsonFeed jsonFeed = new JsonFeed();
        jsonFeed.start();
    }

    private void start() {
            TopicConnection connection = null;
            try {
                //连接工厂，用于产生连接
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JMS_USER, JMS_PASS, JMS_URL);
                //创建连接
                connection = connectionFactory.createTopicConnection();
                connection.start();

                //创建会话
                TopicSession pubSession = connection.createTopicSession(transacted, Session.AUTO_ACKNOWLEDGE);
                //创建消息主题
                Topic topic = pubSession.createTopic(subject);
                //创建消息生产者
                TopicPublisher publisher = pubSession.createPublisher(topic);
                publisher.setDeliveryMode(DeliveryMode.PERSISTENT);
                //循环发送消息
                DataFactory dataFactory = new DataFactory();
                int index = 0;
                while (true){
                    String str = "[message]" + dataFactory.getRandomText(10,20);
                    TextMessage message = pubSession.createTextMessage(str);
                    publisher.publish(message);
                    if(transacted){
                        pubSession.commit();
                    }
                    System.out.println("发送消息: " + message.getText() + ", "+new Date());
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //释放资源
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
