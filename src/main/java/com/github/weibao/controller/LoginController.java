package com.github.weibao.controller;

import com.github.weibao.Contants;
import com.github.weibao.model.User;
import com.github.weibao.service.UserService;
import com.github.weibao.utils.sso.RSAEncrypt;
import com.github.weibao.utils.sso.SsoCookie;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.util.List;

/**
 * Created by dongzhukai on 16/1/11.
 */
@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        Cookie[] cookies = request.getCookies();
        String keyvalue = "";
        if (cookies == null) {
            //cookie 为空时
        } else {
            for (int i = 0; i < cookies.length; i++) {
                // 获得具体的Cookie
                Cookie cookie = cookies[i];
                // 获得Cookie的名称
                if (cookie.getName().equals("sso")) {
                    keyvalue = cookie.getValue();
                } else {
                }
            }
        }
        RSAEncrypt rsa = new RSAEncrypt();
        String keyvalue1;
        try {
            keyvalue = "AEBuWbVu0V4p5A42l5Z7/tePAIUmozXGyGoZu1eqsiM5z6QWS4+K0BsxFSUUAdTZRcSm6XyZT2jMo+H8ePzeKJPR2SKTaCltSLjVqtTvqknCgstfCS1QrlpR2PlS+LNHzHNOH47thEnxUE55T+NIkaJBuN6Q9REoYvnk5UpiSkI=";
            keyvalue1 = rsa.unencrypt(keyvalue);
            String keyvalue2 = URLDecoder.decode(keyvalue1, "utf-8");
            Gson gs = new Gson();
            SsoCookie sso = gs.fromJson(keyvalue2, SsoCookie.class);
            String username = sso.getUsername();
            httpSession.setAttribute(Contants.CURRENT_USER, username);
            String password = sso.getPassword();

            try {

                User user = new User();
                user.setName(username);
                user.setPassword(password);

                Cookie theUsername = new Cookie("username", username);
                theUsername.setMaxAge(60 * 60 * 24 * 365);
                Cookie thePassword = new Cookie("password", password);
                thePassword.setMaxAge(60 * 60 * 24 * 365);

                int userExist = userService.isExist(user);
                if (userExist != 1) {
                    userService.addUser(user);
                }
                List<User> userList = userService.getUsers(user);
                int userId = userList.get(0).getId();
                httpSession.setAttribute(Contants.CURRENT_USERID, userId);
//        int userId = (int) httpSession.getAttribute(Contants.CURRENT_USERID);

//        Integer userId = user.getId();
//        String userId2 = new String(String.valueOf(userId));
//        Cookie theUserId = new Cookie("UserId", userId2);
//        theUserId.setMaxAge(60 * 60 * 24 * 365);
                response.addCookie(theUsername);
                response.addCookie(thePassword);
//        response.addCookie(theUserId);
                return "home";
            } catch (Exception e) {

        e.printStackTrace();
      }
    } catch (BadPaddingException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    }
    return null;
  }

  @RequestMapping("loginout")
  public String loginout(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
    Cookie[] cookies = request.getCookies();
    String value = "";
    // 遍历数组,获得具体的Cookie
    if (cookies == null) {
      System.out.println("没有cookie信息");
    } else {
      for (int i = 0; i < cookies.length; i++) {
        // 获得具体的Cookie
        Cookie cookie = cookies[i];
        // 获得Cookie的名称
        if (cookie.getName().equals("username")) {
          cookie.setMaxAge(0);
          response.addCookie(cookie);
        } else {
        }

      }
    }
    session.removeAttribute(Contants.CURRENT_USER);
    session.removeAttribute(Contants.CURRENT_USERID);
//    return "redirect:/login";
    return "home";
  }
}
