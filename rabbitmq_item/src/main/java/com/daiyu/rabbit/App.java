package com.daiyu.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Author: dyx
 * @Date: 2021/1/29 下午5:06
 */
public class App {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare("q_test_0_1",false,false,false,null);
        // 发送消息
        channel.basicPublish("","q_test_0_1",null,"你好啊".getBytes());
        channel.close();
        connection.close();
    }
}

