package com.github.weibao.test.common;

import com.github.weibao.utils.DateUtils;
import com.github.weibao.utils.FileUtils;
import com.github.weibao.utils.RandomUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by chenkaihua on 15-8-23.
 */
public class CommonTest {


    @Test
    public void testSimpleDateFromat() {
        String timeFromatedString = DateUtils.getCurrentTimeFromatedString();
        assertNotNull(timeFromatedString);
        System.out.println(timeFromatedString);
    }

    @Test
    public void testRandomString() {
        String randomString = RandomUtils.randomString();
        assertNotNull(randomString);
        System.out.println(randomString);
    }


    @Test
    public void testFileUtls() {
        String fileType = FileUtils.getFileType("sfdsafasfimage");
        System.out.println(fileType);
    }

}
