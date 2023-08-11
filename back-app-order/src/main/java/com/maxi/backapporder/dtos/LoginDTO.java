package com.maxi.backapporder.dtos;

import com.maxi.backapporder.enums.LoginRole;

public record LoginDTO(String username, String password, LoginRole role) {
    
}
