package com.github.weibao.model.ext;

import com.github.weibao.model.AgencyStaffs;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/14.
 */
public class AgencyStaffsExt extends AgencyStaffs {
    public List<AgencyStaffsExt> getItemsExtList() {
        return itemsExtList;
    }

    public void setItemsExtList(List<AgencyStaffsExt> itemsExtList) {
        this.itemsExtList = itemsExtList;
    }

    private List<AgencyStaffsExt> itemsExtList;
}
