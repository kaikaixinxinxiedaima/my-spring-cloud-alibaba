package cn.mirrorming.hello.spring.cloud.alibaba.provider.service;

import cn.mirrorming.hello.spring.cloud.alibaba.provider.dto.Book;
import cn.mirrorming.hello.spring.cloud.alibaba.provider.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServcie {
    @Autowired
    private BookMapper bookMapper;


    public List<Book> selectAll(){
        return bookMapper.selectAll();
    }

    public int updateByPrimaryKey(Book book){
        return bookMapper.updateByPrimaryKey(book);
    }

    public Book selectByPrimaryKey(Integer id){
        return bookMapper.selectByPrimaryKey(id);
    }
}
