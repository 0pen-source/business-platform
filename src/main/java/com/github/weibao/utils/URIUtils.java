package com.github.weibao.utils;

import org.springframework.web.util.UriTemplate;

import java.net.URI;

/**
 * Created by chenkaihua on 15-9-16.
 */
public class URIUtils {

    public static URI createURI(String url, Object... uriVariableValues) {
        return new UriTemplate(url).expand(uriVariableValues);
    }

}
