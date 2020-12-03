package cn.mirrorming.spring.cloud.alibaba.rocketmq.consumer;

import cn.mirrorming.spring.cloud.alibaba.rocketmq.consumer.service.MySink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamRetryTemplate;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author mirror
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({MySink.class})
public class RocketMQConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQConsumerApplication.class, args);
    }


    /**
     * Spring Cloud Stream在进行消息的接收处理时也是利用Spring Retry进行了包装的。当消息消费失败时默认会最多试3次（加上第一次），
     * 使用的是Spring Retry的RetryTemplate的默认配置。如果默认的重试逻辑不能满足你的需求，你也可以定义自己的RetryTemplate，
     * 但是需要使用@StreamRetryTemplate进行标注（StreamRetryTemplate上标注了@Bean）。
     * 比如下面的代码中就应用了自定义的RetryTemplate，指定最多尝试5次的消息消费，尝试5次后仍然失败将走前面介绍的异常处理逻辑，即投递消息到相应的异常处理的Channel。
     * @return
     */
    @StreamRetryTemplate
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(new SimpleRetryPolicy(5));
        return retryTemplate;
    }
}
