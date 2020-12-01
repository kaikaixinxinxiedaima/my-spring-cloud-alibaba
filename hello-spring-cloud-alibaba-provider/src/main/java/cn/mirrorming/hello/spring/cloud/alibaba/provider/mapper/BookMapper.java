package cn.mirrorming.hello.spring.cloud.alibaba.provider.mapper;

import cn.mirrorming.hello.spring.cloud.alibaba.provider.dto.Book;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Component
public interface BookMapper extends BaseMapper<Book> {


    int insertList(List<Book> books);

    List<Book> findByKeyWord(String keyword);

}
