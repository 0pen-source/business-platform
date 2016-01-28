package com.github.weibao.mapper;

import com.github.weibao.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by dongzhukai on 16/1/5.
 */
 @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" , "classpath:spring-mybatis.xml"})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() throws Exception {
        List<User> list = userMapper.selectAll();
        for(User user : list){
            System.out.println("User: " + user.getName());
        }
    }

}