package com.pws.pwsapplication.base;

import android.app.Application;
import com.lemon.support.request.RequestManager;
import okhttp3.Cookie;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;

/**
 * Created by yerunjie
 */

public class PwsApplication extends Application {
    public static PwsApplication sAppContext;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public final static boolean debug = true;

    public void onCreate() {
        super.onCreate();
        sAppContext = this;
    }

    public static boolean isLogin() {
        List<Cookie> cookies = RequestManager.create(sAppContext).getCookieJar().getCookieStore().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.name().equals("X-TOKEN")) {
                return true;
            }
        }
        return false;
    }
}
