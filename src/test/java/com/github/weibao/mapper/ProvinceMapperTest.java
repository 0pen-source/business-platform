package com.github.weibao.mapper;

import com.github.weibao.model.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dongzhukai on 16/1/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" , "classpath:spring-mybatis.xml"})
public class ProvinceMapperTest {
    @Resource
    private ProvinceMapper provinceMapper;

    @Test
    public void testSelectAll() throws Exception {
        List<Province> list = provinceMapper.selectAll();
        for(Province province : list){
            System.out.println("Pro: " + province.getName());
        }
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        Province p = provinceMapper.selectByPrimaryKey(1);
        System.out.println("Pro: " + p.getName());
    }
}
