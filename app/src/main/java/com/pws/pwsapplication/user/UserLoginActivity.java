package com.pws.pwsapplication.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.pws.pwsapplication.MainActivity;
import com.pws.pwsapplication.R;
import com.pws.pwsapplication.base.PwsBaseActivity;
import com.pws.pwsapplication.base.PwsBaseCallBack;
import com.pws.pwsapplication.user.api.UserApi;
import com.pws.pwsapplication.user.bean.UserLoginRequest;
import com.pws.pwsapplication.user.bean.UserLoginResponse;

public class UserLoginActivity extends PwsBaseActivity {

    @BindView(R.id.et_telephone)
    EditText et_telephone;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.btn_login)
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telephoneString = et_telephone.getText().toString();
                String userPasswordString = et_password.getText().toString();
                UserLoginRequest request = new UserLoginRequest();
                request.setTelephone(telephoneString);
                request.setPassword(userPasswordString);
                addRequest(getService(UserApi.class).login(request), new PwsBaseCallBack<UserLoginResponse>() {
                    @Override
                    public void onSuccess200(UserLoginResponse userLoginResponse) {
                        makeToast("登陆成功");
                        Log.d(TAG, "onSuccess200: " + userLoginResponse.getToken());
                        Intent intent = new Intent(UserLoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
    }
}
