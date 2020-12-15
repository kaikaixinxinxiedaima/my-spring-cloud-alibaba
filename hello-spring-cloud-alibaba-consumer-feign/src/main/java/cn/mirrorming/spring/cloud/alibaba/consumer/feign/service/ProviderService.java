package cn.mirrorming.spring.cloud.alibaba.consumer.feign.service;

import cn.mirrorming.spring.cloud.alibaba.consumer.feign.controller.config.FeignConfiguration;
import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.fallback.ProviderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mirror
 */
@FeignClient(value = "provider", fallback = ProviderServiceFallback.class/*,configuration = FeignConfiguration.class*/)
public interface ProviderService {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable String message);

    @GetMapping(value = "/updateById/{id}")
    int updateById(@PathVariable Integer id);
}