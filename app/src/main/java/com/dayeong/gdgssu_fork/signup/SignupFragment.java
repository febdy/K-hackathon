package com.dayeong.gdgssu_fork.signup;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dayeong.gdgssu_fork.BaseFragment;
import com.dayeong.gdgssu_fork.Global;
import com.dayeong.gdgssu_fork.R;

/**
 * 회원가입
 */
public class SignupFragment extends BaseFragment implements SignupContract.View {

    private static final String TAG = "SignupFragment";

    private SignupContract.UserActionListener listener;

    private EditText idInput;
    private EditText pwInput;
    private EditText confirmInput;
    private EditText emailInput;

    private Button submitBtn;
    private CoordinatorLayout layout;

    public SignupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listener = new SignupPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        init(view);
        return view;
    }

    @Override
    public void init(View view) {
        idInput = (EditText) view.findViewById(R.id.fragment_signup_id);
        pwInput = (EditText) view.findViewById(R.id.fragment_signup_pw);
        confirmInput = (EditText) view.findViewById(R.id.fragment_signup_confirm);
        emailInput = (EditText) view.findViewById(R.id.fragment_signup_email);

        submitBtn = (Button) view.findViewById(R.id.fragment_signup_submit);
        layout = (CoordinatorLayout) view.findViewById(R.id.fragment_signup_container);

        setListener();
    }

    private void setListener() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idInput.getText().toString();
                String pw = pwInput.getText().toString();
                String confirm = confirmInput.getText().toString();
                String email = emailInput.getText().toString();

                showDialog("회원가입", "잠시만기다려주세요");
                int code = listener.signup(id, pw, confirm, email);

                if (code == Global.ERR_EMPTY_ID)
                    idInput.setError("아이디를 입력해주세요.");
                else if (code == Global.ERR_INVALID_ID)
                    idInput.setError("아이디는 6글자 이상이여야 합니다.");
            }
        });
    }
}
