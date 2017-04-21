package com.Test.util;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;


/**ActiveMqTest 测试ActiveMQ消息队列 发送者
 */
public class ActiveMqSenderTest {
   static Logger logger= LoggerFactory.getLogger(LogUtil.class);

   public static  void main(String[] args){
        ConnectionFactory connectionFactory ;
        Connection connection=null;
        Session session ;
        Destination destination;
        MessageProducer producer;


        connectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                        ActiveMQConnectionFactory.DEFAULT_PASSWORD
                        , "tcp://localhost:61616");
     try {
         /**
          *从链接工厂中获得链接（Connection）
          */
         connection=connectionFactory.createConnection();
         connection.start();
         /**
          * 从连接中获得Session
          */
         session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

         // Destination ：消息的目的地;消息发送给谁.
         // 获取session注意参数值my-queue是Query的名字
         destination = session.createQueue("sanshantest");

         /**
          * 创建消息生产者用于发送消息
          */
         producer =  session.createProducer(destination);

         /**
          * 设置投递方式
          * DeliveryMode.NON_PERSISTENT:不持久化
          *
          * DeliveryMode.PERSISTENT:持久化
          */
         producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

         logger.info("开始传递");

         for (int i = 0; i < 100; i++) {
             /**
              * 创建出一条文本消息
              */
             TextMessage textMessage = session.createTextMessage("我是消息："+i);
             //发送文本消息
             producer.send(textMessage);
         }

        logger.info("消息已入队");

     }catch (JMSException jms){
         logger.error("传递过程出现异常");
         jms.printStackTrace();
     }finally {
         try {
              if (null!=connection){
                  connection.close();
              }
         } catch (JMSException e) {
             logger.error("connection无法正常关闭");
             e.printStackTrace();
         }
     }
    }

}
