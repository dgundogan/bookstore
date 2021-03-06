package com.bookstore.domain.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by DG on 6/13/17.
 */
public class Authority implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 123123L;

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
