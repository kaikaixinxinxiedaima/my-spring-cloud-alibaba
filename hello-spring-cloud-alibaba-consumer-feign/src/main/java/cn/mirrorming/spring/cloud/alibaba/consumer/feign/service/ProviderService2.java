package cn.mirrorming.spring.cloud.alibaba.consumer.feign.service;

import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.fallback.ProviderServiceFallback;
import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.fallback.ProviderServiceFallback2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mirror
 */
@FeignClient(value = "provider2", fallback = ProviderServiceFallback2.class)
public interface ProviderService2 {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable String message);

    @GetMapping(value = "/updateById/{id}")
    int updateById(@PathVariable Integer id);
}