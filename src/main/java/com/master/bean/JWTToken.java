package com.master.bean;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/24 18:00
 */

public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}