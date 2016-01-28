package com.github.weibao.service;

import com.github.weibao.model.ext.ItemStaffLink;
import com.github.weibao.test.unit.BaseUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Create 16/1/27,下午4:04
 * @Author dongzhukai
 */
public class ItemsServiceTest extends BaseUnitTest{

    @Autowired
    private ItemsService itemsService;

    @Test
    public void testInsertItemStaffLink() throws Exception {
        ItemStaffLink itemStaffLink = new ItemStaffLink(146,348);
        itemsService.insertItemStaffLink(itemStaffLink);
    }
}