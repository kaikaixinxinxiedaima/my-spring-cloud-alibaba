package cn.mirrorming.spring.cloud.alibaba.consumer.feign.controller;

import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.ProviderService2;
import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.ProviderService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author mirror
 */
@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;
    @Autowired
    private ProviderService2 providerService2;

    @GetMapping("echo")
    @SentinelResource(value = "getByCode")
    public String echo(HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println("测试gateway");
        System.out.println("token："+token);
        return providerService.echo("Feign Client");
    }


    @GetMapping("update")
    @GlobalTransactional
    public String update() {
        System.out.println("--------------------测试seate--------------");
        providerService.updateById(12);
        providerService2.updateById(14);
        return "success";
    }
}
