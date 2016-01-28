package com.github.weibao.service;

import com.github.weibao.Contants;
import com.github.weibao.model.City;
import com.github.weibao.model.User;
import com.github.weibao.test.unit.BaseUnitTest;
import junit.framework.Assert;
import org.apache.shiro.session.Session;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zwd-apple on 2016/1/19.
 */
public class UserServiceTest extends BaseUnitTest {

@Autowired

private UserService userService;

  @Test
  public void ueser() throws Exception {
    User user = new User();
    user.setName("chenkaihua");
    int userExist = userService.isExist(user);
    System.out.println("_________________"+userExist);
    Assert.assertEquals(1,userExist);
  }
@Test
  public void userId(HttpSession httpSession)throws Exception{
  httpSession.getAttribute(Contants.CURRENT_USERID);
  System.out.println(httpSession.getAttribute(Contants.CURRENT_USERID));
}
}
