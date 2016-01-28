package com.github.weibao.service;

import com.github.weibao.test.unit.BaseUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Create 16/1/19,下午4:34
 * @Author dongzhukai
 */
public class CompanyServiceTest extends BaseUnitTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void testGetAllItemsByCompanyId() throws Exception {
        //List<AgencyItems> list = companyService.getAllItemsByCompanyId("259");
        System.out.println();
    }
}