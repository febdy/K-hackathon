package com.dayeong.gdgssu_fork.signup;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.dao.User;
import com.dayeong.gdgssu_fork.utils.Global;
import com.dayeong.gdgssu_fork.views.BaseFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

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
    protected void init(View view) {
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

                listener.signUp(id, pw, confirm, email);
            }
        });
    }


    @Override
    public void signUpValid(int code) {
        if (code == Global.ERR_EMPTY_ID)
            idInput.setError(getString(R.string.err_empty_id));
        else if (code == Global.ERR_INVALID_ID)
            idInput.setError(getString(R.string.err_invalid_id));
        else if (code == Global.ERR_EMPTY_PW)
            pwInput.setError(getString(R.string.err_empty_pw));
        else if (code == Global.ERR_INVALID_PW)
            pwInput.setError(getString(R.string.err_invalid_pw));
        else if (code == Global.ERR_EMPTY_CONFIRM)
            confirmInput.setError(getString(R.string.err_empty_confirm));
        else if (code == Global.ERR_INVALID_CONFIRM)
            confirmInput.setError(getString(R.string.err_invalid_confirm));
        else if (code == Global.ERR_EMPTY_EMAIL)
            emailInput.setError(getString(R.string.err_empty_email));
        else if (code == Global.ERR_INVALID_EMAIL)
            emailInput.setError(getString(R.string.err_invalid_email));
    }


    @Override
    public void signUp(User user) {
        showDialog(getString(R.string.action_signup), getString(R.string.prompt_wait));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Global.SIGNUP_URL, user.getRequestParams(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d(TAG, "회원가입 성공");
                dismissDialog();
                getActivity().getSupportFragmentManager().popBackStack();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d(TAG, "회원가입 실패");
                dismissDialog();
                Snackbar.make(layout, getString(R.string.fail_to_sign_up), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
