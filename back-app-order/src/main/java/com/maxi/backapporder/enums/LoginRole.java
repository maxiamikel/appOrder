package com.maxi.backapporder.enums;

public enum LoginRole {
    
    ADMIN("admin"), USER("user");

    private String loginRole;

    LoginRole(String loginRole){
        this.loginRole = loginRole;
    }

    public String getLoginRole() {
        return loginRole;
    }
    
}
