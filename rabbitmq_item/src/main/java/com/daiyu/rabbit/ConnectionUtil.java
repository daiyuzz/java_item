package com.daiyu.rabbit;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: dyx
 * @Date: 2021/1/29 下午4:59
 * RabbitMq链接工具
 */
public class ConnectionUtil {
    public static Connection getConnection() throws Exception{
        // 创建连接工场对象
        ConnectionFactory factory = new ConnectionFactory();
        // 指定主机名称
        factory.setHost("localhost");
        // 指定端口号
        factory.setPort(5672);
        // 指定RabbitMq的虚拟主机
        factory.setVirtualHost("/");
        // 账号
        factory.setUsername("guest");
        // 密码
        factory.setPassword("guest");

        return factory.newConnection();

    }

}
