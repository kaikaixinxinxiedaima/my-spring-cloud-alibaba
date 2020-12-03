package cn.mirrorming.spring.cloud.alibaba.rocketmq.consumer.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

@Service
public class ReceiveService {

    @StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }

    @StreamListener("input2")
    public void receiveInput2(String receiveMsg) {
        System.out.println("input2 receive: " + receiveMsg);
    }

    @StreamListener("input3")
    public void receiveInput3(String receiveMsg) {
        System.out.println("input3 receive: " + receiveMsg);
    }

//    @StreamListener("input3")
//    public void receiveInput3(@Payload Foo foo) {
//        System.out.println("input3 receive: " + foo);
//    }

    @StreamListener("input4")
    public void receiveTransactionalMsg(String transactionMsg) {
        System.out.println("input4 receive transaction msg: " + transactionMsg);
    }


    /**
     * 在接收消息时，如果消息处理失败，Spring Cloud会把失败的消息转到名为<destination>.<group>.errors的Channel，并可通过@ServiceActivator方法进行接收
     * @param message
     */
//    @ServiceActivator(inputChannel = "test-topic.test-group3.errors")
//    public void handleConsumeUserError(ErrorMessage message) {
//        System.out.println("收到处理失败的消息："+ message.getPayload());
//    }
}