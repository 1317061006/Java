package com.Test.util;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * **ActiveMqTest 测试ActiveMQ消息队列 接受者
 */
public class ActiveReceiverTest {

    static Logger logger= LoggerFactory.getLogger(LogUtil.class);

    public static void main(String[] args)    {

        ConnectionFactory connectionFactory = new
                ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER
                , ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        /**
         *从链接工厂中获得链接（Connection）
         */
        Connection connection= null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
        } catch (JMSException e) {
            logger.error("创建连接错误"+e);
            e.printStackTrace();
        }

        /**
         * 从连接中获得Session
         */
        Session session = null;
        Destination destination = null;
        try {
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("sanshantest");
        } catch (JMSException e) {
            logger.error("获得session错误"+e);
            e.printStackTrace();
        }


        /**
         * 创建消息生产者用于发送消息
         */
        MessageConsumer messageConsumer = null;
        try {
            messageConsumer = session.createConsumer(destination);
        } catch (JMSException e) {
            logger.error("创建消息错误"+e);
            e.printStackTrace();
        }
        logger.info("开始从消息队列接受信息");
        for (;;) {
            TextMessage textMessage = null;
            try {
                textMessage = (TextMessage)messageConsumer.receive(1000);
                if(textMessage != null) System.out.println(textMessage.getText());
                else break;
            } catch (JMSException e) {
                logger.error("从消息队列获取信息出现错误"+e);
                e.printStackTrace();
            }
        }


        /**
         * 消息提交
         */

        try {
            session.close();
            connection.close();
        } catch (JMSException e) {
            logger.error("关闭错误"+e);
            e.printStackTrace();
        }

    }
}
