package com.github.weibao.mapper;


import com.github.weibao.model.ext.AgencyItemsExt;
import com.github.weibao.model.ext.ItemStaffLink;

import java.util.List;

/**
 * Created by wb on 2016-01-12.
 */
public interface AgencyItemsExtMapper {
    List<AgencyItemsExt> selectAll(String optionvalue, String info, String city, int firstdb, int dbnumber);

    List selectCollect(int user);

    int selectPage(String provincecode, String infoext, String cityext);

    int insertItemStaffLink(ItemStaffLink itemStaffLink);
}
