package com.github.weibao.service;

import com.github.weibao.mapper.AgencyItemsExtMapper;
import com.github.weibao.model.ext.AgencyItemsExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wb on 2016-01-12.
 */
@Service
public class AgencyItemsExtService {
    @Autowired
    AgencyItemsExtMapper agencyItemsExtMapper;

    public List<AgencyItemsExt> selectAll(String optionvalue, String info, String city, int firstdb, int dbnumber) {
        List<AgencyItemsExt> selectlist = agencyItemsExtMapper.selectAll(optionvalue, info, city, firstdb, dbnumber);


        return selectlist;
    }

    public List selectCollect(int user){
        List collectlist = agencyItemsExtMapper.selectCollect(user);
        return collectlist;
    }

    public int getPageNumber(String provincecode, String infoext, String cityext, int dbnumber) {

//        RowBounds rowBounds=new RowBounds(0,4);
//        City city=new City();
//        city.setProvincecode("130000");
//        int page=cityMapper.selectCount(city);
//        List<City> list=cityMapper.selectByRowBounds(city, rowBounds);
//        for (City s:list) {
//            System.out.println(page);
//            System.out.println( s.getName());
//        }
        int page=agencyItemsExtMapper.selectPage(provincecode,infoext,cityext);
//        AgencyItems agencyItems=new AgencyItems();
//        int page=agencyItemsMapper.selectCount(agencyItems);
        page=((page-1)/dbnumber)+1;

        return page;
    }
}
