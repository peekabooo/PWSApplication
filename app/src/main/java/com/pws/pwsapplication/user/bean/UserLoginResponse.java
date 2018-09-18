package com.pws.pwsapplication.user.bean;

import com.pws.pwsapplication.base.BaseJsonResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginResponse extends BaseJsonResponse {
    private String token;
}
