package com.pws.pwsapplication.user.api;

import com.lemon.support.request.SimpleCall;
import com.pws.pwsapplication.user.bean.UserLoginRequest;
import com.pws.pwsapplication.user.bean.UserLoginResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by yerunjie on 2018/9/18
 *
 * @author yerunjie
 */
public interface UserApi {
    @POST("user/login")
    SimpleCall<UserLoginResponse> login(@Body UserLoginRequest request);
}
