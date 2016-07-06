package com.dayeong.gdgssu_fork.login;

import android.os.Bundle;

import com.dayeong.gdgssu_fork.BaseActivity;
import com.dayeong.gdgssu_fork.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_login_container, new LoginFragment())
                .commit();
    }
}
