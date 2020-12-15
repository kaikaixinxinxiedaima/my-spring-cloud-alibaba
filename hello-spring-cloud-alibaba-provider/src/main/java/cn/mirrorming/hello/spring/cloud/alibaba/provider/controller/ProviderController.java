package cn.mirrorming.hello.spring.cloud.alibaba.provider.controller;

import cn.mirrorming.hello.spring.cloud.alibaba.provider.dto.Book;
import cn.mirrorming.hello.spring.cloud.alibaba.provider.service.BookServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @author mirror
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private BookServcie bookServcie;


    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable String message, HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println("token："+token);
        return "Hello Nacos Discovery " + message + " , From port :" + port;
    }


    @GetMapping(value = "/selectAll")
    @ResponseBody
    public List<Book> selectAll() {
        return bookServcie.selectAll();
    }

    @GetMapping(value = "/updateById/{id}")
    @ResponseBody
    public int echo(@PathVariable Integer id) {
        Book book = bookServcie.selectByPrimaryKey(id);
        book.setBookContent("测试seate.."+ UUID.randomUUID());
        return bookServcie.updateByPrimaryKey(book);
    }


}