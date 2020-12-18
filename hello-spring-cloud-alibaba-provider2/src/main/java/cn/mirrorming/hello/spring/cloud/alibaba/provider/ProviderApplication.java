package cn.mirrorming.hello.spring.cloud.alibaba.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author mirror
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.mirrorming.hello.spring.cloud.alibaba.provider.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}