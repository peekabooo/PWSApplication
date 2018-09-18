package com.pws.pwsapplication.user.bean;

import lombok.Data;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
@Data
public class UserLoginRequest {
    private String telephone;
    private String password;
}
