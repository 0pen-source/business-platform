package com.github.weibao.utils.sso;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by wyf on 2015/11/16.
 */
public class SsoCookie {
    public static final String ENCODE = "utf-8";
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        try {
            return URLEncoder.encode("{\"username\":\""+username+"\",\"password\":\""+password+"\"}", ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
