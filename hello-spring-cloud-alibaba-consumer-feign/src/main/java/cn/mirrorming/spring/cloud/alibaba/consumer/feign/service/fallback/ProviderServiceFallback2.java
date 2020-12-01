package cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.fallback;

import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.ProviderService;
import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.ProviderService2;
import org.springframework.stereotype.Component;

/**
 * @author mirror
 */
@Component
public class ProviderServiceFallback2 implements ProviderService2 {
    @Override
    public String echo(String message) {
        return "sentinel fallback";
    }

    @Override
    public int updateById(Integer id) {
        return 0;
    }
}
