package com.dayeong.gdgssu_fork.login;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.dao.User;
import com.dayeong.gdgssu_fork.signup.SignupFragment;
import com.dayeong.gdgssu_fork.views.BaseFragment;

/**
* 로그인
* */
public class LoginFragment extends BaseFragment implements LoginContract.View {

    private static final String TAG = "LoginFragment";

    private EditText idInput;
    private EditText pwInput;
    private Button submitBtn;
    private Button signupBtn;
    private LoginContract.UserActionsListener listener;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        init(view);
        return view;
    }

    @Override
    protected void init(View view) {
        listener = new LoginPresenter(this);

        idInput = (TextInputEditText) view.findViewById(R.id.fragment_login_id);
        pwInput = (TextInputEditText) view.findViewById(R.id.fragment_login_pw);

        submitBtn = (Button) view.findViewById(R.id.fragment_login_submit);
        signupBtn = (Button) view.findViewById(R.id.fragment_login_signup);

        setListener();
    }

    private void setListener() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.login(idInput.getText().toString(), pwInput.getText().toString());
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.signup();
            }
        });
    }

    @Override
    public void loginSuccess(User user) {

    }


    @Override
    public void signup() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_login_container, new SignupFragment())
                .addToBackStack(null)
                .commit();
    }
}
